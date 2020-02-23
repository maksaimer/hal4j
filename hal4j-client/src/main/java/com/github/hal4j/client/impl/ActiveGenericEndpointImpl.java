package com.github.hal4j.client.impl;

import com.github.hal4j.client.ActiveCollectionEndpoint;
import com.github.hal4j.client.ActiveGenericEndpoint;
import com.github.hal4j.client.ActiveResourceEndpoint;
import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.resources.GenericResource;

public class ActiveGenericEndpointImpl extends ActiveEndpointImpl<GenericResource> implements ActiveGenericEndpoint {

    protected ActiveGenericEndpointImpl(GenericResource resource, RequestExecutor client) {
        super(resource, client);
    }

    @Override
    public <T> ActiveResourceEndpoint<T> as(Class<T> type) {
        return new ActiveResourceEndpointImpl<>(resource().as(type), executor());
    }

    @Override
    public <T> ActiveCollectionEndpoint<T> asCollectionOf(Class<T> resourceType) {
        return new ActiveCollectionEndpointImpl<>(resource().asCollectionOf(resourceType), executor());
    }

}
