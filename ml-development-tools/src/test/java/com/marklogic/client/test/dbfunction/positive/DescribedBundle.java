package com.marklogic.client.test.dbfunction.positive;

// IMPORTANT: Do not edit. This file is generated.



import com.marklogic.client.DatabaseClient;

import com.marklogic.client.impl.BaseProxy;

/**
 * A most descriptive class.
 */
public interface DescribedBundle {
    /**
     * Creates a DescribedBundle object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * @param db	provides a client for communicating with the database server
     * @return	an object for session state
     */
    static DescribedBundle on(DatabaseClient db) {
        final class DescribedBundleImpl implements DescribedBundle {
            private BaseProxy baseProxy;

            private DescribedBundleImpl(DatabaseClient dbClient) {
                baseProxy = new BaseProxy(dbClient, "/dbf/test/described/");
            }

            @Override
            public Boolean describer(Integer first) {
              return BaseProxy.BooleanType.toBoolean(
                baseProxy
                .request("describer.sjs", BaseProxy.ParameterValuesKind.SINGLE_ATOMIC)
                .withSession()
                .withParams(
                    BaseProxy.atomicParam("first", false, BaseProxy.IntegerType.fromInteger(first)))
                .withMethod("POST")
                .responseSingle(false, null)
                );
            }

        }

        return new DescribedBundleImpl(db);
    }

  /**
   * A most descriptive method.
   *
   * @param first	Descriptive input.
   * @return	Descriptive output.
   */
    Boolean describer(Integer first);

}
