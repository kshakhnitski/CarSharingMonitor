package com.kshakhnitski.carsharingmonitor.mapper;

import com.kshakhnitski.carsharingmonitor.dto.error.DefaultErrorResponse;
import com.kshakhnitski.carsharingmonitor.dto.error.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.HttpStatus;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;

@Mapper(
        imports = {LocalDateTime.class, Clock.class}
)
public interface ErrorMapper {

    @Mapping(target = "timestamp", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(httpStatus.value())")
    @Mapping(target = "error", source = "httpStatus.reasonPhrase")
    @Mapping(target = "path", source = "request.servletPath")
    DefaultErrorResponse toDefaultErrorResponse(String message,
                                                HttpServletRequest request,
                                                HttpStatus httpStatus);

    @Mapping(target = "timestamp", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(httpStatus.value())")
    @Mapping(target = "error", source = "httpStatus.reasonPhrase")
    @Mapping(target = "path", source = "request.servletPath")
    @Mapping(target = "fieldErrors", source = "fieldErrors")
    @Mapping(target = "message", source = "message")
    ValidationErrorResponse toValidationErrorResponse(String message,
                                                      HttpServletRequest request,
                                                      HttpStatus httpStatus,
                                                      Map<String, String> fieldErrors);
}
