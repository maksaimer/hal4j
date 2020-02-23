package com.github.hal4j.client;

import com.github.hal4j.resources.GenericResource;

public interface ActiveGenericEndpoint extends ActiveEndpoint<GenericResource> {

    <T> ActiveResourceEndpoint<T> as(Class<T> type);

    <T> ActiveCollectionEndpoint<T> asCollectionOf(Class<T> resourceType);

}
