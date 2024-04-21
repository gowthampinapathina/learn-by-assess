package com.stackroute.assessmentservice.repository;

import com.stackroute.assessmentservice.model.AssessmentGeneration;
import com.stackroute.assessmentservice.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssessmentGenerationRepository extends MongoRepository<AssessmentGeneration,String> {

    Optional<AssessmentGeneration> findByBatchId(String batchId);
    AssessmentGeneration deleteByBatchId(String batchId);

}
