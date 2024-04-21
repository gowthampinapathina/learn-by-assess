package com.stackroute.instructorservice.exception;

public class InstructorNotFoundException extends Exception{
    private String message;

    public InstructorNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public InstructorNotFoundException() {
    }
}
