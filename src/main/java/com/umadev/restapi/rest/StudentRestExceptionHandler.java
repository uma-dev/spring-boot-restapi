package com.umadev.restapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    // Add exception handling code 
    
    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc ){
        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        // Jackson will convert the POJO in JSON
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND );
    } 

    // Add a new exception handler to catch all exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exc){
         // Create a StudentErrorResponse
         StudentErrorResponse error = new StudentErrorResponse();
         error.setStatus(HttpStatus.BAD_REQUEST.value());
         error.setMessage(exc.getMessage());
         error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        // Jackson will convert the POJO in JSON
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
