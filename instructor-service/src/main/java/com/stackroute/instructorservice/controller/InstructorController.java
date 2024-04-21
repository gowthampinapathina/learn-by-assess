package com.stackroute.instructorservice.controller;

import com.stackroute.instructorservice.exception.BatchAlreadyExistException;
import com.stackroute.instructorservice.exception.InstructorNotFoundException;
import com.stackroute.instructorservice.model.Batch;
import com.stackroute.instructorservice.model.Learner;
import com.stackroute.instructorservice.service.InstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")
@CrossOrigin(origins = "*")
public class InstructorController {

    @Autowired
    private InstructorServiceImpl instructorService;

    private ResponseEntity responseEntity;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBatch() {
        return new ResponseEntity<>(instructorService.getBatches(),HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createNewBatch(@RequestBody Batch batch){
        try {
            Batch newBatch = instructorService.createBatch(batch);
            responseEntity = new ResponseEntity<>(newBatch,HttpStatus.CREATED);
        }catch (BatchAlreadyExistException e){
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/{instructorMail}")
    public ResponseEntity<?> getAllBatchesByInstructorMailId(@PathVariable String instructorMail){

        try {
            List<Batch> batches = instructorService.getBatchByInstructorEmailId(instructorMail);
            responseEntity = new ResponseEntity(batches,HttpStatus.OK);
        }catch (InstructorNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("/{instructorMail}/{batchName}")
    public ResponseEntity<?> getAllLearners(@PathVariable String instructorMail, @PathVariable String batchName){
        List<Learner> learners = instructorService.getAllLearnersByEmailAndBatchName(instructorMail,batchName);
        responseEntity = new ResponseEntity<>(learners,HttpStatus.FOUND);
        return responseEntity;
    }

    @GetMapping("/BatchList/{instructorMail}")
    public ResponseEntity<?> getBatchListOfInstructor(@PathVariable String instructorMail){
        try {
            List<String> batchList = instructorService.getBatchListOfInstructor(instructorMail);
            responseEntity = new ResponseEntity(batchList,HttpStatus.FOUND);
        }catch (InstructorNotFoundException e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }
}
