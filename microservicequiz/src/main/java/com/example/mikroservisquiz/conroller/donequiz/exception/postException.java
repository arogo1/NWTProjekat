package com.example.mikroservisquiz.conroller.donequiz.exception;

import com.example.mikroservisquiz.models.errors.exception;

import org.springframework.http.HttpStatus;

public class postException extends exception {

    public postException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}