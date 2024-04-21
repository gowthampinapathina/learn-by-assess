package com.stackroute.assessmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    private String assignmentId;
    private String assessorId;
    private AssignmentTemplate assignmentTemplate;
}
