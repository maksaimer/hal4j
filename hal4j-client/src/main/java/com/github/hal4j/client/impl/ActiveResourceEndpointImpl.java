package com.github.hal4j.client.impl;

import com.github.hal4j.client.ActiveResourceEndpoint;
import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.resources.Resource;

public class ActiveResourceEndpointImpl<T> extends ActiveEndpointImpl<Resource<T>> implements ActiveResourceEndpoint<T> {

    protected ActiveResourceEndpointImpl(Resource<T> resource, RequestExecutor client) {
        super(resource, client);
    }

}
