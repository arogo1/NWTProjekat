package com.example.mikroservisquiz.conroller.exceptions;

public class ErrorMessage {
    private String message;
    private String details;

    public ErrorMessage(String message, String details) {
        super();
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}