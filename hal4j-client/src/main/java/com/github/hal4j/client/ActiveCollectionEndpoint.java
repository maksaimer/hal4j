package com.github.hal4j.client;

import com.github.hal4j.resources.Resources;

import java.util.Iterator;
import java.util.stream.Stream;

public interface ActiveCollectionEndpoint<T> extends ActiveEndpoint<Resources<T>>, Iterable<ActiveResourceEndpoint<T>> {

    Stream<ActiveResourceEndpoint<T>> stream();

    @Override
    default Iterator<ActiveResourceEndpoint<T>> iterator() {
        return stream().iterator();
    }

}
