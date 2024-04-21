package com.stackroute.instructorservice.repository;

import com.stackroute.instructorservice.model.Batch;
import com.stackroute.instructorservice.model.Learner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends MongoRepository<Batch, String> {
    public Batch findByBatchName(String batchName);
    public List<Batch> findByInstructorMail(String instructorMail);

    @Query("{instructorMail:?0,batchName:?1}")
    public Batch findByInstructorMailAndBatchName(String instructorMail,String batchName);
}
