package com.xstock.plutus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(Exception ex) {
        // create Payload containing exception details
        if (ex instanceof EntityNotFoundException) {
            HttpStatus notFound = HttpStatus.NOT_FOUND;
            ApiError apiError = new ApiError(
                    ex.getMessage(),
                    ex,
                    notFound,
                    ZonedDateTime.now(ZoneId.of("Z"))
            );
            // return Response Entity
            return new ResponseEntity<>(apiError, notFound);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(ex, status);
        }
    }
}
