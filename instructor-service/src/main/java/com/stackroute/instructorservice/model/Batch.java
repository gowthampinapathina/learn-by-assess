package com.stackroute.instructorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection="batches")
public class Batch {
    @Id
    private String batchId;
    private String batchName;
    private String instructorName;
    private String instructorMail;
    private List<Learner> learner;  //list of the learner object

    @Override
    public String toString() {
        return "Batch{" +
                "batchId='" + batchId + '\'' +
                ", batchName='" + batchName + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", instructorMail='" + instructorMail + '\'' +
                ", learner=" + learner +
                '}';
    }
}

