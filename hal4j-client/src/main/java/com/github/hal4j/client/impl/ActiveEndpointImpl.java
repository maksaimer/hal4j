package com.github.hal4j.client.impl;

import com.github.hal4j.client.*;
import com.github.hal4j.resources.HALLink;
import com.github.hal4j.resources.ResourceSupport;

import java.util.Optional;
import java.util.function.Function;

import static com.github.hal4j.client.DiscoveryHint.matchingAll;
import static com.github.hal4j.resources.HALLink.REL_SELF;

public class ActiveEndpointImpl<R extends ResourceSupport> implements ActiveEndpoint<R> {

    private final R resource;

    private final RequestExecutor client;

    protected ActiveEndpointImpl(R resource, RequestExecutor client) {
        this.resource = resource;
        this.client = client;
    }

    @Override
    public R resource() {
        return this.resource;
    }

    protected RequestExecutor executor() {
        return this.client;
    }

    @Override
    public Optional<ResourceCommand> command(DiscoveryHint... hints) {
        return request(REL_SELF, hints, link -> new ResourceCommandBuilder(link, client));
    }

    @Override
    public Optional<ResourceQuery> query(String rel, DiscoveryHint... hints) {
        return request(rel, hints, link -> new ResourceQueryBuilder(link, client));
    }

    private <T> Optional<T> request(String rel,
                                    DiscoveryHint[] hints,
                                    Function<HALLink, ResourceCallBuilder<T>> factory) {
        return resource.links().findAll(rel)
                .stream()
                .filter(matchingAll(hints))
                .findAny()
                .map(link -> factory.apply(link).build());
    }

}
