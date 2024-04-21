package com.stackroute.assessmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.servlet.http.Part;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class AssessmentGeneration {

//    @Id
//    private String _id;

    @Id
    private String batchId;
    private String instructorName;
    private String instructorEmailId;
    private List<Assignment> assignments;
    private List<Participant> participants;
}
