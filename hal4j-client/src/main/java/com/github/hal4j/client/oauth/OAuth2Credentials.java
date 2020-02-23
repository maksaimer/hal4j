package com.github.hal4j.client.oauth;

import java.util.function.BiConsumer;

public abstract class OAuth2Credentials {

    public abstract void forEach(BiConsumer<String, String> item);

    public static OAuth2Credentials password(String username, String password) {
        return null;
    }

    public static OAuth2Credentials client(String clientId, String clientSecret) {
        return null;
    }

    public static OAuth2Credentials refresh(OAuth2Token token) {
        return null;
    }
}
