package com.example.microserviceuser.models.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleRequestException(Exception e){
    	 ErrorMessage response = new ErrorMessage(e.getStatus(),e.getMessage(), e.getDetails());

         return new ResponseEntity<ErrorMessage>(response, new HttpHeaders(), e.getStatus());
    }

}
