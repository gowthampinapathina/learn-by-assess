package com.stackroute.learnerservice.repository;

import com.stackroute.learnerservice.exception.LearnerAlreadyExistException;
import com.stackroute.learnerservice.model.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

@Repository
public interface LearnerRepository extends MongoRepository<Learner,String> {

        public Optional<Learner> findByEmailId(String emailId);
    //public Learner findByEmailAndPassword(String emailId,String password);
}
