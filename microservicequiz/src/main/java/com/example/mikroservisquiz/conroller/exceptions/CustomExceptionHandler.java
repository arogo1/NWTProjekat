package com.example.mikroservisquiz.conroller.exceptions;

import com.example.mikroservisquiz.models.errors.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleError(exception ex) {
        ErrorMessage response = new ErrorMessage(ex.getMessage(), ex.getDetails());

        return new ResponseEntity<ErrorMessage>(response, new HttpHeaders(), ex.getStatus());
    }
}