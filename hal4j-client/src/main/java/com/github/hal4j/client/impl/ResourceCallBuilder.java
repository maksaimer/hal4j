package com.github.hal4j.client.impl;

import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.resources.HALLink;

abstract class ResourceCallBuilder<T> {

    private final HALLink link;
    private final RequestExecutor client;

    ResourceCallBuilder(HALLink link, RequestExecutor client) {
        this.link = link;
        this.client = client;
    }

    public T build() {
        return doBuild(client, link);
    }

    abstract T doBuild(RequestExecutor client, HALLink link);
}
