package com.xstock.plutus.utils.exception;

public class GrpcResponseException extends RuntimeException {
    private static final String defaultMessage = "Unable to process response from gRPC server";

    public GrpcResponseException() {
        super(defaultMessage);
    }

    public GrpcResponseException(String message) {
        super(message);
    }

    public GrpcResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
