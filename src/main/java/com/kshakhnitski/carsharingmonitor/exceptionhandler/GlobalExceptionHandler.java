package com.kshakhnitski.carsharingmonitor.exceptionhandler;

import com.kshakhnitski.carsharingmonitor.dto.error.DefaultErrorResponse;
import com.kshakhnitski.carsharingmonitor.dto.error.ValidationErrorResponse;
import com.kshakhnitski.carsharingmonitor.exception.NotFoundException;
import com.kshakhnitski.carsharingmonitor.mapper.ErrorMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    private final ErrorMapper mapper;

    private static final String VALIDATION_ERROR_MESSAGE = "Validation error";
    private static final String DEFAULT_FIELD_ERROR_MESSAGE = "Provided invalid value";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ValidationErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                   HttpServletRequest request) {
        //noinspection Convert2MethodRef
        Map<String, String> fieldErrors = exception.getFieldErrors().stream()
                .collect(Collectors.toMap(
                        e -> e.getField(),
                        e -> (e.getDefaultMessage() != null) ? e.getDefaultMessage() : DEFAULT_FIELD_ERROR_MESSAGE
                ));
        return mapper.toValidationErrorResponse(VALIDATION_ERROR_MESSAGE, request, HttpStatus.BAD_REQUEST, fieldErrors);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DefaultErrorResponse handleNotFound(NotFoundException exception, HttpServletRequest request) {
        return mapper.toDefaultErrorResponse(exception.getMessage(), request, HttpStatus.NOT_FOUND);
    }
}
