package com.stackroute.emailservice.exception;



public class EmailNotFoundException extends Exception{

    public EmailNotFoundException(String message, EmailNotFoundException e){
        super(message);

    }
    public EmailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
