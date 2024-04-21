package com.stackroute.assessmentservice.service;

import com.stackroute.assessmentservice.exceptions.*;
import com.stackroute.assessmentservice.model.*;
import com.stackroute.assessmentservice.repository.AssessmentGenerationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AssessmentGenerationServiceImpl implements AssessmentGenerationService {

    private AssessmentGenerationRepository repository;
    private MongoTemplate mongoTemplate;

    private static Logger logger = LoggerFactory.getLogger(AssessmentGenerationServiceImpl.class);

    @Autowired
    public AssessmentGenerationServiceImpl(AssessmentGenerationRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public AssessmentGeneration saveAssessmentGenerationForTheNewBatch(AssessmentGeneration assessmentGeneration) throws BatchIdAlreadyExistsException, AssessmentInvalidException {
        Optional<AssessmentGeneration> assessmentGeneration1 = repository.findByBatchId(assessmentGeneration.getBatchId());
        if (assessmentGeneration.getBatchId() == null) {
            throw new AssessmentInvalidException();
        }
        if (assessmentGeneration1.isPresent()) {
            throw new BatchIdAlreadyExistsException();
        }
        return repository.save(assessmentGeneration);
    }

    @Override
    public List<AssignmentQuestion> getAssignmentByAssignmentIdAndBatchId(String assignmentId, String batchId) throws AssessmentsNotFoundException {
        List<Assignment> assignmentByBatchIdList = new ArrayList<>();
        List<Assignment> assignmentList = new ArrayList<>();
        Query query = new Query(Criteria.where("batchId").is(batchId));
        List<AssessmentGeneration> assessmentGenerations = mongoTemplate.find(query, AssessmentGeneration.class);
        if (assessmentGenerations.size() > 0) {
            assignmentByBatchIdList = assessmentGenerations.get(0).getAssignments();
        } else {
            logger.error("No batch with batchId: " + batchId + " present");
            return null;
        }
        for (Assignment element : assignmentByBatchIdList) {
            System.out.println("element:" + element.getAssignmentId());
            if (element.getAssignmentId().equals(assignmentId)) {
                assignmentList.add(element);
                System.out.println("matched list:" + assignmentList);
            }
        }
        if (assignmentList.size() == 0) {
            throw new AssessmentsNotFoundException();
        }
        return assignmentList.get(0).getAssignmentTemplate().getQuestions();
    }

    @Override
    public List<Assignment> getAllAssignmentsByBatchId(String batchId) throws AssessmentsNotFoundException {
        List<Assignment> assignmentsListByBatchId = new ArrayList<Assignment>();
        Query query = new Query(Criteria.where("batchId").is(batchId));
        List<AssessmentGeneration> assessmentGenerations = mongoTemplate.find(query, AssessmentGeneration.class);
        assignmentsListByBatchId = assessmentGenerations.get(0).getAssignments();
        if (!(assignmentsListByBatchId.size() > 0)) {
            throw new AssessmentsNotFoundException();
        }
        return assignmentsListByBatchId;
    }

//    @Override
//    public List<Assignment> getAllPendingAssignmentsForLearner(String batchId) throws AssessmentsNotFoundException {
//        List<Assignment> assignmentsListByBatchId = new ArrayList<Assignment>();
//        List<Assignment> pendingAssignmentsForLearner = new ArrayList<Assignment>();
//        Query query = new Query(Criteria.where("batchId").is(batchId));
//        List<AssessmentGeneration> assessmentGenerations = mongoTemplate.find(query, AssessmentGeneration.class);
//        assignmentsListByBatchId = assessmentGenerations.get(0).getAssignments();
//
//        for (Assignment element : assignmentsListByBatchId) {
//            String assignmentStatus = element.getAssignmentTemplate().getParticipants().getAssignmentStatus();
//            System.out.println("element:" + element.getAssignmentTemplate().getParticipant().getAssignmentStatus());
//            if (assignmentStatus.equals("pending")) {
//                pendingAssignmentsForLearner.add(element);
//                System.out.println("pendingAssignmentsForLearner: " + pendingAssignmentsForLearner);
//                System.out.println("---------------------");
//            }
//        }
//
//        if (pendingAssignmentsForLearner.size() == 0) {
//            throw new AssessmentsNotFoundException();
////            logger.error("Assignment with the " + batchId + " has no pending Assignments.");
//        }
//        return pendingAssignmentsForLearner;
//    }

//    @Override
//    public List<Assignment> getAllCompletedAssignmentsForLearners(String batchId) throws AssessmentsNotFoundException {
//        List<Assignment> assignmentsListByBatchId = new ArrayList<Assignment>();
//        List<Assignment> completedAssignmentsForLearner = new ArrayList<Assignment>();
//        Query query = new Query(Criteria.where("batchId").is(batchId));
//        List<AssessmentGeneration> assessmentGenerations = mongoTemplate.find(query, AssessmentGeneration.class);
//        assignmentsListByBatchId = assessmentGenerations.get(0).getAssignments();
//
//        for (Assignment element : assignmentsListByBatchId) {
//            String assignmentStatus = element.getAssignmentTemplate().getParticipant().getAssignmentStatus();
//            System.out.println("element:" + element.getAssignmentTemplate().getParticipant().getAssignmentStatus());
//            if (assignmentStatus.equals("completed")) {
//                completedAssignmentsForLearner.add(element);
//                System.out.println("pendingAssignmentsForLearner: " + completedAssignmentsForLearner);
//                System.out.println("---------------------");
//            }
//        }
//        if (completedAssignmentsForLearner.size() == 0) {
//            throw new AssessmentsNotFoundException();
////                logger.error("Assignment with the " + batchId + " has no pending Assignments.");
//        }
//        return completedAssignmentsForLearner;
//    }

    @Override
    public List<AssessmentGeneration> getAllBatchesData() throws NoDataFoundException {
        if (!(repository.findAll().size() > 0)) {
            throw new NoDataFoundException();
        }
        return (List<AssessmentGeneration>) repository.findAll();
    }

    @Override
    public List<AssessmentGeneration> givenBatchIdShouldDeleteTheAssessmentGeneration(String batchId) throws BatchIdNotFoundException {
        if (repository.findByBatchId(batchId).isPresent()) {
            repository.deleteByBatchId(batchId);
        } else {
            throw new BatchIdNotFoundException();
        }
        return repository.findAll();
    }

    @Override
    public AssessmentGeneration givenBatchIdAndAssignmentShouldDeleteTheAssignment(String batchId, String assignmentId) throws BatchIdNotFoundException, AssessmentsNotFoundException {
        Optional<AssessmentGeneration> batch = repository.findByBatchId(batchId);
        Assignment assignmentToBeRemoved = new Assignment();
        if (batch.isPresent()) {
            List<Assignment> assignmentList = batch.get().getAssignments();
            if (assignmentList == null) {
                throw new AssessmentsNotFoundException();
            } else {
                for (Assignment element : assignmentList) {
                    if (element.getAssignmentId().equals(assignmentId)) {
                        assignmentToBeRemoved = element;
                    }
                }
                assignmentList.remove(assignmentToBeRemoved);
            }
            Query query = new Query(Criteria.where("batchId").is(batchId));
            Update updateQuery = new Update();
            updateQuery.set("assignments", assignmentList);
            mongoTemplate.upsert(query, updateQuery, AssessmentGeneration.class);
            return batch.get();
        } else {

//            logger.error("Batch with id:"+batchId+" doesn't exist!!!");
            throw new BatchIdNotFoundException();
        }
    }

    @Override
    public Assignment updateAssignment(String batchId, String assignmentId, Assignment assignment) throws AssessmentsNotFoundException, BatchIdNotFoundException {
        Optional<AssessmentGeneration> batch = repository.findByBatchId(batchId);
        if (batch.isPresent()) {
            List<Assignment> assignmentList = batch.get().getAssignments();
            if (assignmentList.size() == 0) {
                throw new AssessmentsNotFoundException();
            } else {
                assignmentList.removeIf(element -> element.getAssignmentId().equals(assignmentId));
                assignmentList.add(assignment);
            }
            Query query = new Query(Criteria.where("batchId").is(batchId));
            Update updateQuery = new Update();
            updateQuery.set("assignments", assignmentList);
            mongoTemplate.upsert(query, updateQuery, AssessmentGeneration.class);
            return assignment;
        } else {
            throw new BatchIdNotFoundException();
        }
    }

    @Override
    public Assignment addQuestionsInAssignment(String batchId, String assignmentId, AssignmentQuestion assignmentQuestions) throws BatchIdNotFoundException, AssessmentsNotFoundException {
        Optional<AssessmentGeneration> batch = repository.findByBatchId(batchId);
        if (batch.isPresent()) {
            List<Assignment> assignmentList = batch.get().getAssignments();
            Assignment existAssignment = new Assignment();
            if (assignmentList.size() == 0) {
                throw new AssessmentsNotFoundException();
            } else {
                for (Assignment element : assignmentList) {
                    if (element.getAssignmentId().equals(assignmentId)) {
                        existAssignment = element;
                        AssignmentTemplate existingAssignmentTemplate = new AssignmentTemplate();
                        existingAssignmentTemplate = existAssignment.getAssignmentTemplate();
                        List<AssignmentQuestion> existingQuestions = new ArrayList<>();
                        existingQuestions = existingAssignmentTemplate.getQuestions();
                        if (existingQuestions == null) {
                            List<AssignmentQuestion> questionToBeAdded = new ArrayList<>();
                            questionToBeAdded.add(assignmentQuestions);
                            existingAssignmentTemplate.setQuestions(questionToBeAdded);
                        } else {
                            existingQuestions.add(assignmentQuestions);
                        }
                    }
                }
//                assignmentList.add(existAssignment);
            }
            Query query = new Query(Criteria.where("batchId").is(batchId));
            Update updateQuery = new Update();
            updateQuery.set("assignments", assignmentList);
            mongoTemplate.upsert(query, updateQuery, AssessmentGeneration.class);
            return existAssignment;
        } else {
            throw new BatchIdNotFoundException();
        }
    }


    @Override
    public AssessmentGeneration saveAssignmentInTheGivenBatchId(String batchId, Assignment assignment) throws AssessmentsAlreadyExistsException, BatchIdNotFoundException {
        Optional<AssessmentGeneration> batch = repository.findByBatchId(batchId);
        if (batch.isPresent()) {
            List<Assignment> assignmentList = batch.get().getAssignments();
            if (assignmentList == null) {
                List<Assignment> assignmentToBeAdded = new ArrayList<>();
                assignmentToBeAdded.add(assignment);
                assignmentList = assignmentToBeAdded;
            } else {
                for (Assignment element : assignmentList) {
                    if (element.getAssignmentId().equals(assignment.getAssignmentId())) {
                        logger.error("Assignment with id:" + assignment.getAssignmentId() + " a;ready exists");
                        throw new AssessmentsAlreadyExistsException();
                    }
                }
                assignmentList.add(assignment);
            }
            Query query = new Query(Criteria.where("batchId").is(batchId));
            Update updateQuery = new Update();
            updateQuery.set("assignments", assignmentList);
            mongoTemplate.upsert(query, updateQuery, AssessmentGeneration.class);
            return batch.get();
        } else {

//            logger.error("Batch with id:"+batchId+" doesn't exist!!!");
            throw new BatchIdNotFoundException();
//            return null;
        }
    }

    @Override
    public void addLearnerAnswer(String batchId, String assignmentId, Integer questionId, LearnerAnswer learnerAnswer) throws AssessmentsNotFoundException, BatchIdNotFoundException {
        Optional<AssessmentGeneration> batch = repository.findByBatchId(batchId);
        if (batch.isPresent()) {
            List<Assignment> assignmentList = batch.get().getAssignments();
            Assignment existAssignment = new Assignment();
            if (assignmentList.size() == 0) {
                throw new AssessmentsNotFoundException();
            } else {
                for (Assignment element : assignmentList) {
                    if (element.getAssignmentId().equals(assignmentId)) {
                        existAssignment = element;
                        AssignmentTemplate existingAssignmentTemplate = new AssignmentTemplate();
                        existingAssignmentTemplate = existAssignment.getAssignmentTemplate();
                        List<AssignmentQuestion> existingQuestions = existingAssignmentTemplate.getQuestions();
                        for (AssignmentQuestion questionElement : existingQuestions) {
                            if (questionElement.getQuestionId() == questionId) {
                                List<LearnerAnswer> existingLearnerAnswer = questionElement.getLearnerAnswers();
                                if (existingLearnerAnswer == null) {
                                    List<LearnerAnswer> answerToBeAdded = new ArrayList<>();
                                    answerToBeAdded.add(learnerAnswer);
                                    questionElement.setLearnerAnswers(answerToBeAdded);
                                    existingAssignmentTemplate.setQuestions(existingQuestions);
                                } else {
                                    existingLearnerAnswer.add(learnerAnswer);
                                }
                            }
                        }
                    }
                }
            }
            Query query = new Query(Criteria.where("batchId").is(batchId));
            Update updateQuery = new Update();
            updateQuery.set("assignments", assignmentList);
            mongoTemplate.upsert(query, updateQuery, AssessmentGeneration.class);
        } else {
            throw new BatchIdNotFoundException();
        }
    }

    @Override
    public List<AssessmentGeneration> getAssessment(String email) {
        Query query = new Query(Criteria.where("assignments.assessorId").is(email));
        List<AssessmentGeneration> assessmentGenerations = mongoTemplate.find(query, AssessmentGeneration.class);
        return assessmentGenerations;
    }

    @Override
    public List<AssessmentGeneration> getAssignment(String email) {
        Query query = new Query(Criteria.where("participants.mailId").is(email));
        List<AssessmentGeneration> assessmentGenerations = mongoTemplate.find(query, AssessmentGeneration.class);
        return assessmentGenerations;
    }
}
