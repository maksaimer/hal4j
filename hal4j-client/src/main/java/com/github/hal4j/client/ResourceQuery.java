package com.github.hal4j.client;

import com.github.hal4j.uritemplate.ParamHolder;

import java.util.concurrent.CompletableFuture;

public interface ResourceQuery {

    CompletableFuture<ActiveGenericEndpoint> fetch(RequestHint... hints);

    CompletableFuture<ActiveGenericEndpoint> fetch(ParamHolder holder, RequestHint... hints);

    default <T> CompletableFuture<ActiveResourceEndpoint<T>> fetch(Class<T> type, RequestHint... hints) {
        return fetch(hints).thenApply(resource -> resource.as(type));
    }

    default <T> CompletableFuture<ActiveResourceEndpoint<T>> fetch(ParamHolder holder, Class<T> type, RequestHint... hints) {
        return fetch(holder, hints).thenApply(resource -> resource.as(type));
    }

}
