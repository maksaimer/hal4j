package com.github.hal4j.client;

import com.github.hal4j.resources.ResourceSupport;

import java.util.Optional;

import static com.github.hal4j.resources.HALLink.REL_SELF;

public interface ActiveEndpoint<R extends ResourceSupport> {

    R resource();

    Optional<ResourceCommand> command(DiscoveryHint... hint);

    Optional<ResourceQuery> query(String rel, DiscoveryHint... hints);

    default Optional<ResourceQuery> self() {
        return query(REL_SELF);
    }

}
