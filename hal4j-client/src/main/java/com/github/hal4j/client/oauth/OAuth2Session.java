package com.github.hal4j.client.oauth;

import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.client.RequestHint;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

public class OAuth2Session implements RequestHint {

    private final Clock clock;

    private final String tokenEndpoint;

    private OAuth2Token token;

    private ReentrantLock tokenLock = new ReentrantLock();

    public OAuth2Session(Clock clock, String tokenEndpoint) {
        this.clock = clock;
        this.tokenEndpoint = tokenEndpoint;
    }

    public void start(RequestExecutor executor, OAuth2Credentials credentials) {
        tokenLock.lock();
        try {
            List<NameValuePair> form = new ArrayList<>();
            credentials.forEach((name, value) -> form.add(new BasicNameValuePair(name, value)));
            Request request = Request.Post(tokenEndpoint).bodyForm(form);
            this.token = executor.query(request)
                    .thenApply(resource -> resource.as(OAuth2Token.class).value())
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new OAuth2ClientException("Failed to fetch token", e);
        } finally {
            tokenLock.unlock();
        }
    }

    @Override
    public void accept(RequestExecutor executor, Request request) {
        if (token.isExpired(clock)) {
            if (token.isRefreshable()) {
                refresh(executor);
            } else {
                throw new OAuth2TokenExpiredException();
            }
        }
        request.addHeader(HttpHeaders.AUTHORIZATION, token.authorization());
    }

    private void refresh(RequestExecutor executor) {
        start(executor, OAuth2Credentials.refresh(this.token));
    }

}
