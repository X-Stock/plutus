package com.xstock.plutus.utils.dto;

import java.time.ZonedDateTime;

public record ErrorMessage(ZonedDateTime timestamp, int status, String error, String path) {
    public ErrorMessage(int status, String error, String path) {
        this(ZonedDateTime.now(), status, error, path);
    }
}
