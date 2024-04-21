package com.stackroute.assessmentservice.service;

import com.stackroute.assessmentservice.exceptions.*;
import com.stackroute.assessmentservice.model.*;

import java.util.List;

public interface AssessmentGenerationService {

      AssessmentGeneration saveAssessmentGenerationForTheNewBatch(AssessmentGeneration assessmentGeneration) throws BatchIdAlreadyExistsException, AssessmentInvalidException;
      AssessmentGeneration saveAssignmentInTheGivenBatchId(String batchId,Assignment assignment) throws AssessmentsAlreadyExistsException, BatchIdNotFoundException;
      List<AssignmentQuestion> getAssignmentByAssignmentIdAndBatchId(String assignmentId, String batchId) throws AssessmentsNotFoundException;
      List<Assignment> getAllAssignmentsByBatchId(String batchId) throws AssessmentsNotFoundException;
//      List<Assignment> getAllPendingAssignmentsForLearner(String batchId) throws AssessmentsNotFoundException;  //Get all pending assignment for learner if assignmentStatus is "pending".
//      List<Assignment> getAllCompletedAssignmentsForLearners(String batchId) throws AssessmentsNotFoundException; //Get All Completed assignments for leaner if assignmentStatus is "completed";
      List<AssessmentGeneration> getAllBatchesData() throws NoDataFoundException;
      List<AssessmentGeneration> givenBatchIdShouldDeleteTheAssessmentGeneration(String batchId) throws BatchIdNotFoundException;
      AssessmentGeneration givenBatchIdAndAssignmentShouldDeleteTheAssignment(String batchId, String assignmentId) throws BatchIdNotFoundException,AssessmentsNotFoundException;
      Assignment updateAssignment(String batchId, String assignmentId, Assignment assignment) throws AssessmentsNotFoundException,BatchIdNotFoundException;
      Assignment addQuestionsInAssignment(String batchId, String  assignmentId, AssignmentQuestion assignmentQuestions) throws BatchIdNotFoundException,AssessmentsNotFoundException;
      void addLearnerAnswer(String batchId, String assignmentId, Integer questionId, LearnerAnswer learnerAnswer) throws AssessmentsNotFoundException, BatchIdNotFoundException;
      List<AssessmentGeneration> getAssessment(String email);
      List<AssessmentGeneration> getAssignment(String email);
}
