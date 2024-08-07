package com.xstock.plutus.utils.dto;

import java.time.ZonedDateTime;

public record ErrorMessage(String message, ZonedDateTime timestamp, String description) {
    public ErrorMessage(String message, String description) {
        this(message, ZonedDateTime.now(), description);
    }
}
