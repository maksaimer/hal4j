package com.github.hal4j.client;

import com.github.hal4j.resources.Resource;

public interface ActiveResourceEndpoint<T> extends ActiveEndpoint<Resource<T>> {

    default T value() {
        return resource().value();
    }

}
