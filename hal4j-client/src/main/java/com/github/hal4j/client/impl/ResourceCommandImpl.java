package com.github.hal4j.client.impl;

import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.client.RequestHint;
import com.github.hal4j.client.ResourceCommand;
import com.github.hal4j.resources.HALLink;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ResourceCommandImpl implements ResourceCommand {


    private final RequestExecutor client;
    private final HALLink link;

    public ResourceCommandImpl(RequestExecutor client, HALLink link) {
        this.client = client;
        this.link = link;
    }

    @Override
    public <T> CompletableFuture<T> request(Function<URI, Request> method,
                                           Function<Response, T> response,
                                           RequestHint... hints) {
        URI uri = link.uri();
        Request request = method.apply(uri);
        for (RequestHint hint : hints) {
            hint.accept(client, request);
        }
        return client.execute(request).thenApply(response);
    }

}
