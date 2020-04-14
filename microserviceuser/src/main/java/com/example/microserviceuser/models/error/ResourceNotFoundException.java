package com.example.microserviceuser.models.error;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends Exception {
	
	public ResourceNotFoundException(String message) {
		 super(HttpStatus.EXPECTATION_FAILED, message);
	}
	
	public ResourceNotFoundException(int id) {
        super(HttpStatus.NOT_FOUND,"Could not find quiz with ID = " + id + "!", "");
    }
    
}
