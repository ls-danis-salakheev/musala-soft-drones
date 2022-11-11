package com.musala.testdrones.danissalakheev.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ResponseStatus(INTERNAL_SERVER_ERROR)
public class ResourcesException extends RuntimeException {

    public ResourcesException(String message) {
        super(message);
    }
}
