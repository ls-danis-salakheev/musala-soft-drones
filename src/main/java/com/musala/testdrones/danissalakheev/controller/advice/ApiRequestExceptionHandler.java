package com.musala.testdrones.danissalakheev.controller.advice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.musala.testdrones.danissalakheev.exception.ApiExceptionResponse;
import com.musala.testdrones.danissalakheev.exception.DroneProcessException;
import com.musala.testdrones.danissalakheev.exception.EntityProcessException;
import com.musala.testdrones.danissalakheev.exception.ResourcesException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

import static java.time.ZoneId.of;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ApiRequestExceptionHandler {

    @Value("${app.default.zoneId}")
    private String defaultZoneId;

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({DroneProcessException.class})
    public ApiExceptionResponse doEntityProcessException(DroneProcessException exception, HttpServletRequest request) {
        return new ApiExceptionResponse(exception.getMessage(),
                request.getServletPath(),
                BAD_REQUEST,
                ZonedDateTime.now(of(defaultZoneId)));
    }

    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ResourcesException.class})
    public ApiExceptionResponse doHandleResourcesException(ResourcesException exception, HttpServletRequest request) {
        return new ApiExceptionResponse(exception.getMessage(),
                request.getServletPath(),
                INTERNAL_SERVER_ERROR,
                ZonedDateTime.now(of(defaultZoneId)));
    }

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({EntityProcessException.class})
    public ApiExceptionResponse doEntityProcessException(EntityProcessException exception, HttpServletRequest request) {
        return new ApiExceptionResponse(exception.getMessage(),
                request.getServletPath(),
                NOT_FOUND,
                ZonedDateTime.now(of(defaultZoneId)));
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class, MissingServletRequestPartException.class})
    public ApiExceptionResponse handleMissingParameterOrPartException(Exception exception, HttpServletRequest request) {
        return new ApiExceptionResponse(exception.getMessage(),
                request.getServletPath(),
                BAD_REQUEST,
                ZonedDateTime.now(of(defaultZoneId)));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({JsonParseException.class, JsonMappingException.class})
    public ApiExceptionResponse handleJsonParsingError(Exception exception, HttpServletRequest request) {
        return new ApiExceptionResponse(exception.getMessage(),
                request.getServletPath(),
                BAD_REQUEST,
                ZonedDateTime.now(of(defaultZoneId)));
    }
}
