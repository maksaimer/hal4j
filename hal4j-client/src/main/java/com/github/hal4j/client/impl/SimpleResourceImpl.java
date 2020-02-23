package com.github.hal4j.client.impl;

import com.github.hal4j.client.*;
import com.github.hal4j.resources.HALLink;
import com.github.hal4j.uritemplate.ParamHolder;
import org.apache.http.client.fluent.Request;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

public class SimpleResourceImpl implements ResourceQuery {

    private final RequestExecutor client;
    private final HALLink link;

    public SimpleResourceImpl(RequestExecutor client, HALLink link) {
        this.client = client;
        this.link = link;
    }

    @Override
    public CompletableFuture<ActiveGenericEndpoint> fetch(RequestHint... hints) {
        URI uri = link.uri();
        return query(uri, hints);
    }

    @Override
    public CompletableFuture<ActiveGenericEndpoint> fetch(ParamHolder holder, RequestHint... hints) {
        URI uri = link.template().expand(holder).toURI();
        return query(uri, hints);
    }

    private CompletableFuture<ActiveGenericEndpoint> query(URI uri, RequestHint... hints) {
        Request request = Request.Get(uri);
        for (RequestHint hint: hints) {
            hint.accept(client, request);
        }
        return client.query(request)
                .thenApply(resource -> new ActiveGenericEndpointImpl(resource, client));
    }

}
