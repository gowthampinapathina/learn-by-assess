package com.stackroute.learnerservice.service;

import com.stackroute.learnerservice.exception.LearnerAlreadyExistException;
import com.stackroute.learnerservice.model.Learner;
import com.stackroute.learnerservice.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LearnerServiceImpl implements LearnerService{
    @Autowired
    LearnerRepository learnerRepository;

    @Value("${app.service.message1}")
    private String message1;

    @Override
    public Learner saveLearner(Learner learner) throws LearnerAlreadyExistException{
        Optional<Learner> learnerResult = learnerRepository.findById(learner.getEmailId());
        if(learnerResult.isPresent()){
            throw new LearnerAlreadyExistException(message1);
        }
            //Learner.setPassword(Bcrypt.hashpw(learner.getPassword(),Bcrypt.gensalt());
        return learnerRepository.save(learner);
    }

    @Override
    public Optional<Learner> getLearnerByEmailId(String emailId) throws Exception {
        Optional<Learner> learner = learnerRepository.findByEmailId(emailId);
        if (learner.isPresent())
        {
            return learner;
        }
        else
        {
            throw new Exception();
        }
    }

    @Override
    public List<Learner> getAllLearners() {
        return learnerRepository.findAll();
    }
    /*@Override
    public Learner findByEmailAndPassword(String email,String password)throws LearnerNotFoundException {
        Optional<Learner> authLearner = learnerRepository.findByEmail(email);
        if(authLearner.isPresent()&&BCrypt.checkpw(password, authLearner.get().getPassword())){
            return authLearner.get();
        }
        throw new LearnerNotFoundException();

    }*/
}


