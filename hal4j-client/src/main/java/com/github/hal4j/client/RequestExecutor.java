package com.github.hal4j.client;

import com.github.hal4j.jackson.JacksonHALMapper;
import com.github.hal4j.resources.GenericResource;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.util.concurrent.CompletableFuture;

public interface RequestExecutor {

    CompletableFuture<Response> execute(Request request);

    CompletableFuture<GenericResource> query(Request request);

    JacksonHALMapper json();

}
