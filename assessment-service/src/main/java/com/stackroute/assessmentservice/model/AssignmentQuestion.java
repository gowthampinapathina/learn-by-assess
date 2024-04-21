package com.stackroute.assessmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentQuestion {
    private Integer questionId;
    private String questionType;
    private String questionStem;
    private String comments;
    private String questionLevel;
    private Integer questionMark;
    private List<Options> optionsStatus;
    private String correctAnswer;
    private List<LearnerAnswer> learnerAnswers;
}

    