package com.example.mikroservisquiz.conroller.donequiz.exception;

import com.example.mikroservisquiz.models.errors.exception;

import org.springframework.http.HttpStatus;

public class doneQuizNotFoundException extends exception{
    public doneQuizNotFoundException(int id) {
        super(HttpStatus.NOT_FOUND,"Could not find done quiz with ID = " + id + ".", "");
    }
}