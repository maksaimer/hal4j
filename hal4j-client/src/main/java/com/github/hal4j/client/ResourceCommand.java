package com.github.hal4j.client;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface ResourceCommand {

    <T> CompletableFuture<T> request(Function<URI, Request> method,
                                     Function<Response, T> response,
                                     RequestHint... hints);

}
