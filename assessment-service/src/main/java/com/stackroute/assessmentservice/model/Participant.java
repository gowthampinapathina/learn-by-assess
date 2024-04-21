package com.stackroute.assessmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    private String mailId;
    private Integer score;
    private String assignmentStatus; //"pending" , "completed",
}
