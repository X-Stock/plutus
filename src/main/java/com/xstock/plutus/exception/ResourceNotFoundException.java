package com.xstock.plutus.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entity) {
        super("Failed to retrieve " + entity);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
