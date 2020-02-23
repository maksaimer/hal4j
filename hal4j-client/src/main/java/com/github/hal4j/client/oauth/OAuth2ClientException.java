package com.github.hal4j.client.oauth;

public class OAuth2ClientException extends RuntimeException {
    public OAuth2ClientException() {
    }

    public OAuth2ClientException(String message) {
        super(message);
    }

    public OAuth2ClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public OAuth2ClientException(Throwable cause) {
        super(cause);
    }
}
