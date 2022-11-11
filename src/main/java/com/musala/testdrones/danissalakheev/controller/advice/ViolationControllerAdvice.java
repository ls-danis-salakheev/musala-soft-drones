package com.musala.testdrones.danissalakheev.controller.advice;

import com.musala.testdrones.danissalakheev.service.impl.ErrorResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static com.musala.testdrones.danissalakheev.service.impl.ErrorResponse.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ViolationControllerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    ErrorResponse onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        Message message = new Message();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            message.getViolationList().add(new Violation()
                    .setFieldName(fieldError.getField())
                    .setMessage(fieldError.getDefaultMessage()));
        }
        return new ErrorResponse().setMessage(message);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    ErrorResponse onConstraintViolationException(
            ConstraintViolationException e) {
        Message message = new Message();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            message.getViolationList().add(new Violation()
                    .setFieldName(constraintViolation.getPropertyPath().toString())
                    .setMessage(constraintViolation.getMessage()));
        }
        return new ErrorResponse().setMessage(message);
    }
}
