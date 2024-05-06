package com.xstock.plutus.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity) {
        super("Failed to retrieve " + entity);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
