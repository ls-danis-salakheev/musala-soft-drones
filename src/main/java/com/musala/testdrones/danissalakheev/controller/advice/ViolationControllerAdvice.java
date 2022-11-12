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

import static com.musala.testdrones.danissalakheev.service.impl.ErrorResponse.Message;
import static com.musala.testdrones.danissalakheev.service.impl.ErrorResponse.Violation;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ViolationControllerAdvice {

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Message message = new Message();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            message.getViolationList().add(new Violation()
                    .setFieldName(fieldError.getField())
                    .setMessage(fieldError.getDefaultMessage()));
        }
        return new ErrorResponse(message);
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public ErrorResponse onConstraintViolationException(ConstraintViolationException exception) {
        Message message = new Message();
        for (ConstraintViolation<?> constraintViolation : exception.getConstraintViolations()) {
            message.getViolationList().add(new Violation()
                    .setFieldName(constraintViolation.getPropertyPath().toString())
                    .setMessage(constraintViolation.getMessage()));
        }
        return new ErrorResponse(message);
    }
}
