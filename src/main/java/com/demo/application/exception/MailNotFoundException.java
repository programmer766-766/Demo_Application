package com.demo.application.exception;

public class MailNotFoundException extends RuntimeException {
    public MailNotFoundException(String message) {
        super(message);
    }
}
