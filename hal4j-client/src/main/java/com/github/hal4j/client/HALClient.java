package com.github.hal4j.client;

import java.util.concurrent.CompletableFuture;

import static com.github.hal4j.client.impl.ResourceQueryBuilder.query;

public class HALClient {

    private final RequestExecutor executor;

    public HALClient(RequestExecutor executor) {
        this.executor = executor;
    }

    public CompletableFuture<ActiveGenericEndpoint> start(String endpoint) {
        return query(endpoint, executor).build().fetch();
    }

}
