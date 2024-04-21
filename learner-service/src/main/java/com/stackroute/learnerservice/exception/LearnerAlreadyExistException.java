package com.stackroute.learnerservice.exception;

public class LearnerAlreadyExistException extends Exception{
    private String message;

    public LearnerAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }

    public LearnerAlreadyExistException() {

    }
}
