package com.example.microserviceuser.models.error;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private HttpStatus status;
    private String message;
    private String details;

    public ErrorMessage(HttpStatus status,String message, String details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
}
