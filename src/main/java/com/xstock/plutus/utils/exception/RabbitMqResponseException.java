package com.xstock.plutus.utils.exception;

public class RabbitMqResponseException extends RuntimeException {
    private static final String defaultMessage = "Unable to process response from RabbitMQ server";

    public RabbitMqResponseException() {
        super(defaultMessage);
    }

    public RabbitMqResponseException(String message) {
        super(message);
    }

    public RabbitMqResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
