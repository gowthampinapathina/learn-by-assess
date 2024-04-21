package com.stackroute.learnerservice.controller;

import com.stackroute.learnerservice.exception.LearnerAlreadyExistException;
import com.stackroute.learnerservice.model.Learner;
import com.stackroute.learnerservice.service.LearnerService;
import com.stackroute.learnerservice.service.RabbitMqLearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/learner")
@CrossOrigin(origins = "*")
public class LearnerController {

    private LearnerService learnerService;

    private RabbitMqLearnerService rabbitMqLearnerService;

    @Autowired
    public LearnerController(LearnerService learnerService, RabbitMqLearnerService rabbitMqLearnerService) {
        this.learnerService = learnerService;
        this.rabbitMqLearnerService = rabbitMqLearnerService;
    }

    ResponseEntity<?> responseEntity;
    @PostMapping("/learner")
    public ResponseEntity<?> registerLearner(@RequestBody Learner learner) {
        try {
            Learner newLearner = learnerService.saveLearner(learner);
            responseEntity = new ResponseEntity<>(newLearner,HttpStatus.OK);
            rabbitMqLearnerService.send(learner);
        }catch(LearnerAlreadyExistException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }

    @GetMapping("/getLearner/{emailId}")
    public ResponseEntity<Optional<Learner>> getLearnerByEmailId(@PathVariable("emailId") String emailId) throws Exception {
        return new ResponseEntity<Optional<Learner>>(learnerService.getLearnerByEmailId(emailId),HttpStatus.OK);
    }

    @GetMapping("/getAllLearners")
    public ResponseEntity<List<Learner>> getAllLearners()
    {
        return new ResponseEntity<List<Learner>>(learnerService.getAllLearners(),HttpStatus.FOUND);
    }


}
