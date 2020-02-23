package com.github.hal4j.client;

import org.apache.http.HttpHeaders;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.util.Locale;
import java.util.function.BiConsumer;

public interface RequestHint extends BiConsumer<RequestExecutor, Request> {

    static RequestHint json(Object model) {
        return (executor, request) -> request.bodyString(executor.json().serialize(model), ContentType.APPLICATION_JSON);
    }

    static RequestHint accept(Locale locale) {
        return ($, request) -> request.addHeader(HttpHeaders.ACCEPT_LANGUAGE, locale.toLanguageTag());
    }

}
