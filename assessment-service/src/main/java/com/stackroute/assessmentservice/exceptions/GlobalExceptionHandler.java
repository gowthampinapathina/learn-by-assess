package com.stackroute.assessmentservice.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
    @Value(value = "${data.exception.message3}")
    private String message3;
    @Value(value = "${data.exception.message4}" )
    private String message4;
    @Value(value = "${data.exception.message5}" )
    private String message5;
    @Value(value = "${data.exception.message6}" )
    private String message6;


    @ExceptionHandler(value = AssessmentInvalidException.class)
    public ResponseEntity<String> assessmentInvalidException(AssessmentInvalidException assessmentInvalidException){
        return new ResponseEntity<>(message1, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AssessmentsNotFoundException.class)
    public ResponseEntity<String> AssessmentsNotFoundException( AssessmentsNotFoundException assessmentsNotFoundException){
        return new ResponseEntity<>(message2, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AssessmentsAlreadyExistsException.class)
    public ResponseEntity<String> assessmentsAlreadyExistsException(AssessmentsAlreadyExistsException assessmentsAlreadyExistsException){
        return new ResponseEntity<>(message3, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(value = NoDataFoundException.class)
    public ResponseEntity<String> noDataFoundException(NoDataFoundException noDataFoundException) {
        return new ResponseEntity<>(message4,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BatchIdNotFoundException.class)
    public ResponseEntity<String> batchIdNotFoundException(BatchIdNotFoundException batchIdNotFoundException) {
        return new ResponseEntity<>(message5,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BatchIdAlreadyExistsException.class)
    public ResponseEntity<String> batchIdAlreadyExistsException(BatchIdAlreadyExistsException batchIdAlreadyExistsException) {
        return new ResponseEntity<>(message6, HttpStatus.ALREADY_REPORTED);
    }
}