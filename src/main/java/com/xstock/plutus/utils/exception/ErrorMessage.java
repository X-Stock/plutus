package com.xstock.plutus.utils.exception;

import java.time.ZonedDateTime;

public record ErrorMessage(String message, ZonedDateTime timestamp, String description) {

}
