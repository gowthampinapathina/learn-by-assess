package com.stackroute.instructorservice.exception;

public class BatchAlreadyExistException extends Exception{
    private String message;

    public BatchAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }

    public BatchAlreadyExistException() {
    }
}
