package com.github.hal4j.client.impl;

import com.github.hal4j.client.ActiveCollectionEndpoint;
import com.github.hal4j.client.ActiveResourceEndpoint;
import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.resources.Resources;

import java.util.stream.Stream;

public class ActiveCollectionEndpointImpl<T> extends ActiveEndpointImpl<Resources<T>> implements ActiveCollectionEndpoint<T> {

    protected ActiveCollectionEndpointImpl(Resources<T> resource, RequestExecutor client) {
        super(resource, client);
    }

    @Override
    public Stream<ActiveResourceEndpoint<T>> stream() {
        return resource().stream().map(resource -> new ActiveResourceEndpointImpl<>(resource, executor()));
    }

}
