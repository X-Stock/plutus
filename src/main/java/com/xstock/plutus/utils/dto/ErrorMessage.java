package com.xstock.plutus.utils.dto;

import java.time.ZonedDateTime;

public record ErrorMessage(String message, ZonedDateTime timestamp, String description) {

}
