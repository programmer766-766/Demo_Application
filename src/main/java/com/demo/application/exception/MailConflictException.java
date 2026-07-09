package com.demo.application.exception;

public class MailConflictException extends RuntimeException {
    public MailConflictException(String message) {
        super(message);
    }
}
