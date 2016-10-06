/*
 * Copyright 2015 MarkLogic Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marklogic.client.datamovement;

import com.marklogic.client.DatabaseClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.NoHttpResponseException;

import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HostAvailabilityListener implements FailureListener<QueryHostException>, BatchFailureListener<WriteEvent> {
  private static Logger logger = LoggerFactory.getLogger(HostAvailabilityListener.class);
  private DataMovementManager moveMgr;
  private HostBatcher batcher;
  private Duration suspendTimeForHostUnavailable = Duration.ofMinutes(1);
  private int minHosts = 1;
  private ScheduledFuture<?> future;
  List<Class<?>> hostUnavailableExceptions = new ArrayList<>();
  {
    hostUnavailableExceptions.add(NoHttpResponseException.class);
    hostUnavailableExceptions.add(SocketException.class);
    hostUnavailableExceptions.add(SSLException.class);
    hostUnavailableExceptions.add(UnknownHostException.class);
  }

  public HostAvailabilityListener(DataMovementManager moveMgr, HostBatcher batcher) {
    if (moveMgr == null) throw new IllegalArgumentException("moveMgr must not be null");
    if (batcher == null) throw new IllegalArgumentException("batcher must not be null");
    this.moveMgr = moveMgr;
    this.batcher = batcher;
  }

  /** If a host becomes unavailable (NoHttpResponseException, SocketException, SSLException,
   * UnknownHostException), adds it to the blacklist
   */
  public HostAvailabilityListener withSuspendTimeForHostUnavailable(Duration
  duration) {
    if (duration == null) throw new IllegalArgumentException("duration must not be null");
    this.suspendTimeForHostUnavailable = duration;
    return this;
  }

  /** If less than minHosts are left, calls stopJob.
   */
  public HostAvailabilityListener withMinHosts(int numHosts) {
    this.minHosts = numHosts;
    return this;
  }

  /** Overwrites the list of exceptions for which a host will be blacklisted
   */
  public HostAvailabilityListener withHostUnavailableExceptions(Class<Throwable>... exceptionTypes) {
    hostUnavailableExceptions = new ArrayList<>();
    for ( Class<Throwable> exception : exceptionTypes ) {
      hostUnavailableExceptions.add(exception);
    }
    return this;
  }

  public Throwable[] getHostUnavailableExceptions() {
    return hostUnavailableExceptions.toArray(new Throwable[hostUnavailableExceptions.size()]);
  }

  public Duration getSuspendTimeForHostUnavailable() {
    return suspendTimeForHostUnavailable;
  }

  public int getMinHosts() {
    return minHosts;
  }

  public void processEvent(DatabaseClient hostClient, Batch<WriteEvent> batch, Throwable throwable) {
    processException(throwable, hostClient.getHost());
  }

  public void processFailure(DatabaseClient client, QueryHostException throwable) {
    processException(throwable, client.getHost());
  }

  public void processException(Throwable throwable, String host) {
    if ( isHostUnavailableException(throwable, new HashSet<>()) ) {
      ForestConfiguration existingForestConfig = batcher.getForestConfig();
      if ( minHosts < existingForestConfig.getHosts().length ) {
        logger.error("ERROR: host unavailable \"" + host + "\", black-listing it for " +
          suspendTimeForHostUnavailable.toString(), throwable);
        ForestConfiguration filteredForestConfig =
          new FilteredForestConfiguration(existingForestConfig)
            .withBlackList(host);
        batcher.withForestConfig(filteredForestConfig);
        // cancel any previously scheduled re-sync
        if ( future != null ) future.cancel(false);
        // schedule a re-sync with the server forest config
        future = Executors.newScheduledThreadPool(1)
          .schedule( () -> {
              ForestConfiguration currentForestConfig = moveMgr.readForestConfig();
              // set the forestConfig back to whatever the server says it is
              batcher.withForestConfig(currentForestConfig);
              String hosts = Stream.of(currentForestConfig.listForests())
                .map((forest) -> forest.getHost())
                .distinct()
                .collect(Collectors.joining(", "));
              logger.info("it's been {} since host {} failed, opening communication to all server hosts [{}]",
                suspendTimeForHostUnavailable.toString(), host, hosts);
            }
            , suspendTimeForHostUnavailable.toMillis(), TimeUnit.MILLISECONDS);
      } else {
        // by black-listing this host we'd move below minHosts, so it's time to
        // stop this job
        logger.error("Encountered [" + throwable + "] on host \"" + host +
          "\" but black-listing it would drop job below minHosts (" + minHosts +
          "), so stopping job \"" + batcher.getJobName() + "\"", throwable);
        moveMgr.stopJob(batcher);
      }
    }
  }

  private boolean isHostUnavailableException(Throwable throwable, Set<Throwable> path) {
    for ( Class<?> type : hostUnavailableExceptions ) {
      if ( type.isInstance(throwable) ) {
        return true;
      }
    }
    // we need to check our recursion path to avoid infinite recursion if a
    // getCause() pointed to itself or an ancestor
    if ( throwable.getCause() != null && ! path.contains(throwable.getCause()) ) {
      path.add(throwable.getCause());
      boolean isCauseHostUnavailableException = isHostUnavailableException(throwable.getCause(), path);
      if ( isCauseHostUnavailableException == true ) return true;
    }
    return false;
  }
}
