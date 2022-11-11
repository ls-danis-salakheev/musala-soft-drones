package com.musala.testdrones.danissalakheev.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class OverloadedException extends RuntimeException {

    public OverloadedException(String message) {
        super(message);
    }
}
