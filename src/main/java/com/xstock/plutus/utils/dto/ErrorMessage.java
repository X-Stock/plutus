package com.xstock.plutus.utils.dto;

import java.time.ZonedDateTime;

public record ErrorMessage(ZonedDateTime timestamp, int status, Object message, String path) {
    public ErrorMessage(int status, Object error, String path) {
        this(ZonedDateTime.now(), status, error, path);
    }
}
