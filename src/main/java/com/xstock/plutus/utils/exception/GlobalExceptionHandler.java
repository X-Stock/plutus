package com.xstock.plutus.utils.exception;

import com.xstock.plutus.utils.dto.ErrorMessage;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ErrorMessage handleNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = RabbitMqResponseException.class)
    public ErrorMessage handleGrpcException(RabbitMqResponseException ex, WebRequest request) {
        return new ErrorMessage(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ErrorMessage handleMethodValidationExceptions(
            HandlerMethodValidationException ex,
            WebRequest request
    ) {
        Map<String, String> errors = ex.getParameterValidationResults().stream()
                .collect(Collectors.toUnmodifiableMap(
                        error -> {
                            String parameterName = error.getMethodParameter().getParameterName();
                            return parameterName == null
                                    ? "Unknown parameter"
                                    : parameterName;
                        },
                        error -> error.getResolvableErrors().stream()
                                .map(MessageSourceResolvable::getDefaultMessage)
                                .collect(Collectors.joining("; "))
                ));

        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                errors,
                request.getDescription(false)
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage handleValidationExceptions(
            MethodArgumentNotValidException ex,
            WebRequest request
    ) {
        Map<String, String> errors = ex.getBindingResult().getAllErrors().stream()
                .collect(Collectors.toUnmodifiableMap(
                        error -> ((FieldError) error).getField(), // Key: field name
                        error -> {
                            String message = error.getDefaultMessage();
                            return message == null ? "Unknown message" : message; // Value: message message
                        },
                        (existing, replacement) -> existing + "; " + replacement // Merge messages
                ));

        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                errors,
                request.getDescription(false)
        );
    }
}
