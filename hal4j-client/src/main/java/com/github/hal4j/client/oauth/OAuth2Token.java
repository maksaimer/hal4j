package com.github.hal4j.client.oauth;

import java.time.Clock;

public class OAuth2Token {

    public boolean isRefreshable() {
        return false;
    }

    public boolean isExpired(Clock clock) {
        return false;
    }

    public String authorization() {
        return null;
    }
}
