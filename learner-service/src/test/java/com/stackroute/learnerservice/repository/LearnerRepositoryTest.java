package com.stackroute.learnerservice.repository;

import com.stackroute.learnerservice.model.Learner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LearnerRepositoryTest {
    @Autowired
    private LearnerRepository learnerRepository;
    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        Learner learner = new Learner("rankadhanush99@gmail.com", "dhanush","Kumar","password",
                "7823028608","male",22,"","learner");
        learnerRepository.save(learner);
        Learner learner1= learnerRepository.findById(learner.getEmailId()).get();
        assertNotNull(learner1);
        assertEquals(learner.getEmailId(),learner1.getEmailId());
;    }
}
