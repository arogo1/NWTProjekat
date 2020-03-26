package com.example.mikroservisquiz.Conroller;

public class QuizNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public QuizNotFoundException(Integer id) {
        super("Could not find quiz with ID = " + id + ".");
    }
}