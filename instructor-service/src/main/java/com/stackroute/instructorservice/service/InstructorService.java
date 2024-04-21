package com.stackroute.instructorservice.service;

import com.stackroute.instructorservice.exception.BatchAlreadyExistException;
import com.stackroute.instructorservice.exception.InstructorNotFoundException;
import com.stackroute.instructorservice.model.Batch;
import com.stackroute.instructorservice.model.Learner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {

    public Batch createBatch(Batch batch) throws BatchAlreadyExistException;
    public List<Batch> getBatches();
    public List<Batch> getBatchByInstructorEmailId(String emailId) throws InstructorNotFoundException;
    public List<Learner> getAllLearnersByEmailAndBatchName(String emailId, String batchName);

    public List<String> getBatchListOfInstructor(String emailId) throws InstructorNotFoundException;
}
