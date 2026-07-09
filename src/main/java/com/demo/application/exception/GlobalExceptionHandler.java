package com.demo.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// This class will handle all the exception

@ControllerAdvice
public class GlobalExceptionHandler {

//    This is the responsible for NotFoundException

    @ExceptionHandler(value = {IdNotFoundException.class,ProductNotFoundException.class,MailNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

//This is responsible for ConflictException

    @ExceptionHandler(value = MailConflictException.class)
    public ResponseEntity<String> handleConflictException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
