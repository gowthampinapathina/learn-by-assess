package com.stackroute.learnerservice.exception;

@SuppressWarnings("serial")
public class LearnerNotFoundException extends Exception{
    private String message;

    public LearnerNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public LearnerNotFoundException() {
    }
}
