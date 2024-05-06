package com.xstock.plutus.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApiError(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {

}
