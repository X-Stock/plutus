package com.xstock.plutus.utils.exception;

import com.xstock.plutus.utils.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ErrorMessage(
                404,
                ex.getMessage(),
                request.getDescription(false)
        );
    }

    @ExceptionHandler(value = GrpcResponseException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage handleGrpcException(GrpcResponseException ex, WebRequest request) {
        return new ErrorMessage(
                422,
                ex.getMessage(),
                request.getDescription(false)
        );
    }
}
