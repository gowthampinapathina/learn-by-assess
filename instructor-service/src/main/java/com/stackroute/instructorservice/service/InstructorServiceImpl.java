package com.stackroute.instructorservice.service;

import com.stackroute.instructorservice.exception.BatchAlreadyExistException;
import com.stackroute.instructorservice.exception.InstructorNotFoundException;
import com.stackroute.instructorservice.model.Batch;
import com.stackroute.instructorservice.model.Learner;
import com.stackroute.instructorservice.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Value("${app.service.message1}")
    private String batchAlreadyExistMessage;


    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository=instructorRepository;
    }


    @Override
    public Batch createBatch(Batch batch) throws BatchAlreadyExistException {
        Batch findBatch = instructorRepository.findByBatchName(batch.getBatchName());
        if (findBatch == null){
            return instructorRepository.save(batch);
        }else{
            throw new BatchAlreadyExistException(batchAlreadyExistMessage);
        }
    }

    @Override
    public List<Batch> getBatches() {
        return instructorRepository.findAll();
    }

    @Override
    public List<Batch> getBatchByInstructorEmailId(String instructorMail) throws InstructorNotFoundException {
        List<Batch> listOfBatch = instructorRepository.findByInstructorMail(instructorMail);
        if (listOfBatch == null){
            throw new InstructorNotFoundException();
        }else{
            return listOfBatch;
        }
    }

    @Override
    public List<Learner> getAllLearnersByEmailAndBatchName(String instructorMail, String batchName) {
        Batch foundBatch = instructorRepository.findByInstructorMailAndBatchName(instructorMail,batchName);
        return foundBatch.getLearner();
    }

    @Override
    public List<String> getBatchListOfInstructor(String instructorMail) throws InstructorNotFoundException {
        List<Batch> batchList =instructorRepository.findByInstructorMail(instructorMail);
        if (batchList==null){
            throw new InstructorNotFoundException();
        }else{
            List<String> listFound = new ArrayList<>();
            for (Batch batch: batchList){
                listFound.add(batch.getBatchName());
            }
            return listFound;
        }
    }
}
