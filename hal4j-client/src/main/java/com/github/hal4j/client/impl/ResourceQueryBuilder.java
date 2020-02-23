package com.github.hal4j.client.impl;

import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.client.ResourceQuery;
import com.github.hal4j.resources.HALLink;
import com.github.hal4j.resources.HALLinkBuilder;

import static com.github.hal4j.resources.HALLinkBuilder.uri;

public class ResourceQueryBuilder extends ResourceCallBuilder<ResourceQuery> {

    public static ResourceQueryBuilder query(String endpoint, RequestExecutor executor) {
        return query(uri(endpoint), executor);
    }

    public static ResourceQueryBuilder query(HALLinkBuilder link, RequestExecutor executor) {
        return query(link.build(), executor);
    }

    public static ResourceQueryBuilder query(HALLink link, RequestExecutor executor) {
        return new ResourceQueryBuilder(link, executor);
    }

    ResourceQueryBuilder(HALLink link, RequestExecutor client) {
        super(link, client);
    }

    @Override
    ResourceQuery doBuild(RequestExecutor client, HALLink link) {
        return new SimpleResourceImpl(client, link);
    }

}
