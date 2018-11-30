/*
 * Copyright 2012-2018 MarkLogic Corporation
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
package com.marklogic.client;

import com.marklogic.client.impl.FailedRequest;

/**
 * Exception thrown when the server responds with HTTP status code 404.
 * Access the failed request payload using getFailedRequest()
 *
 */
@SuppressWarnings("serial")
public class ResourceNotFoundException extends MarkLogicServerException {

  public ResourceNotFoundException(String message) {
    super(message);
  }
  public ResourceNotFoundException(String localMessage,
                                   FailedRequest failedRequest) {
    super(localMessage, failedRequest);
  }

}
