package com.musala.testdrones.danissalakheev.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class EntityProcessException extends RuntimeException {

    public EntityProcessException(String message) {
        super(message);
    }
}
