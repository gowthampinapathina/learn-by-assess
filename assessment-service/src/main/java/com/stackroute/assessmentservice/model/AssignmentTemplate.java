package com.stackroute.assessmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentTemplate {
    private String assessmentName;
    private String assessmentDiscipline;
    private LocalDateTime assessmentStartTime;
    private LocalDateTime assessmentEndTime;
    private List<String> rules;
    private Integer totalScore;
    private String status; //whether it is reviewed or not
    private String assessmentConcept;
    private List<GradingRubrics> levels;
    private List<AssignmentQuestion> questions;

//    public AssignmentTemplate() {}
//
//    public AssignmentTemplate(String assessmentName, String assessmentDiscipline, String assessmentStartTime, String assessmentEndTime, List<String> rules, Integer totalScore, String status, String assessmentConcept, List<GradingRubrics> levels, List<AssignmentQuestion> questions, List<Participant> participants) {
//        this.assessmentName = assessmentName;
//        this.assessmentDiscipline = assessmentDiscipline;
//        this.assessmentStartTime = assessmentStartTime;
//        this.assessmentEndTime = assessmentEndTime;
//        this.rules = rules;
//        this.totalScore = totalScore;
//        this.status = status;
//        this.assessmentConcept = assessmentConcept;
//        this.levels = levels;
//        this.questions = questions;
//        this.participants = participants;
//    }
//
//
//    public String getAssessmentName() {
//        return assessmentName;
//    }
//
//    public void setAssessmentName(String assessmentName) {
//        this.assessmentName = assessmentName;
//    }
//
//    public String getAssessmentDiscipline() {
//        return assessmentDiscipline;
//    }
//
//    public void setAssessmentDiscipline(String assessmentDiscipline) {
//        this.assessmentDiscipline = assessmentDiscipline;
//    }
//
//    public List<String> getRules() {
//        return rules;
//    }
//
//    public void setRules(List<String> rules) {
//        this.rules = rules;
//    }
//
//    public Integer getTotalScore() {
//        return totalScore;
//    }
//
//    public void setTotalScore(Integer totalScore) {
//        this.totalScore = totalScore;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getAssessmentConcept() {
//        return assessmentConcept;
//    }
//
//    public void setAssessmentConcept(String assessmentConcept) {
//        this.assessmentConcept = assessmentConcept;
//    }
//
//    public List<GradingRubrics> getLevels() {
//        return levels;
//    }
//
//    public void setLevels(List<GradingRubrics> levels) {
//        this.levels = levels;
//    }
//
//    public List<AssignmentQuestion> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<AssignmentQuestion> questions) {
//        this.questions = questions;
//    }
//
//    public List<Participant> getParticipants() {
//        return participants;
//    }
//
//    public void setParticipant(List<Participant> participants) {
//        this.participants = participants;
//    }
//
//
//    public String getAssessmentStartTime() {
//        return assessmentStartTime;
//    }
//
//    public void setAssessmentStartTime(String  assessmentStartTime) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(assessmentStartTime, formatter);
//        this.assessmentStartTime = dateTime.toString();
//    }
//
//    public String getAssessmentEndTime() {
//        return assessmentEndTime;
//    }
//
//    public void setAssessmentEndTime(String assessmentEndTime) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(assessmentEndTime, formatter);
//        this.assessmentStartTime = dateTime.toString();
//    }
//
//    @Override
//    public String toString() {
//        return "AssignmentTemplate{" +
//                "assessmentName='" + assessmentName + '\'' +
//                ", assessmentDiscipline='" + assessmentDiscipline + '\'' +
//                ", assessmentStartTime='" + assessmentStartTime + '\'' +
//                ", assessmentEndTime='" + assessmentEndTime + '\'' +
//                ", rules=" + rules +
//                ", totalScore=" + totalScore +
//                ", status='" + status + '\'' +
//                ", assessmentConcept='" + assessmentConcept + '\'' +
//                ", levels=" + levels +
//                ", questions=" + questions +
//                ", participants=" + participants +
//                '}';
//    }
}
