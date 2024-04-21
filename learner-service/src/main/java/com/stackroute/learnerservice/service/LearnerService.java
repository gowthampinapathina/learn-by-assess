package com.stackroute.learnerservice.service;

import com.stackroute.learnerservice.exception.LearnerAlreadyExistException;
import com.stackroute.learnerservice.model.Learner;
import com.stackroute.learnerservice.exception.*;

import java.util.List;
import java.util.Optional;

public interface LearnerService {

    Learner saveLearner(Learner learner) throws LearnerAlreadyExistException;
    //Learner findByEmailAndPassword(String email,String password) throws LearnerNotFoundException;
    Optional<Learner> getLearnerByEmailId(String emailId) throws Exception;
    List<Learner> getAllLearners();

}
