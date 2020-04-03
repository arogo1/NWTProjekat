package com.example.mikroservisquiz.conroller.quiz.exception;

import com.example.mikroservisquiz.models.errors.exception;

import org.springframework.http.HttpStatus;

public class quizNotFoundException extends exception {
    public quizNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND,"Could not find quiz with ID = " + id + ".", "");
    }
}