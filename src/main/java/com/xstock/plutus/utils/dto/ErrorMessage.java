package com.xstock.plutus.utils.dto;

import java.time.ZonedDateTime;

public record ErrorMessage(ZonedDateTime timestamp, int status, String error, String description) {
    public ErrorMessage(int status, String error, String description) {
        this(ZonedDateTime.now(), status, error, description);
    }
}
