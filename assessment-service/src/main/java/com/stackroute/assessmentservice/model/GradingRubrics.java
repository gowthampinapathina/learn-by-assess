package com.stackroute.assessmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradingRubrics {
    private String level;
    private Integer numberOfQuestions;
    private Integer scoreForThisLevel;
    private String typeOfQuestions;
}
