package com.stackroute.assessmentservice.controller;

import com.stackroute.assessmentservice.exceptions.*;

import com.stackroute.assessmentservice.model.*;
import com.stackroute.assessmentservice.service.AssessmentGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/assessment")
public class AssessmentGenerationController {

    private AssessmentGenerationService service;

    @Autowired
    public AssessmentGenerationController(AssessmentGenerationService service) {
        this.service = service;
    }

    @PostMapping("/new_batch_assessment")
    public ResponseEntity<AssessmentGeneration> saveAssessmentGenerationForTheNewBatch(@RequestBody AssessmentGeneration assessmentGeneration) throws BatchIdAlreadyExistsException, AssessmentInvalidException {
            return new ResponseEntity<AssessmentGeneration>(service.saveAssessmentGenerationForTheNewBatch(assessmentGeneration), HttpStatus.CREATED);
    }

    @PostMapping("/add-assignment/{batchId}")
    public ResponseEntity<AssessmentGeneration> saveAssignmentInTheGivenBatchId(@PathVariable("batchId") String batchId, @RequestBody Assignment assignment) throws AssessmentsAlreadyExistsException, BatchIdNotFoundException {
        try {
            return new ResponseEntity<AssessmentGeneration>(service.saveAssignmentInTheGivenBatchId(batchId,assignment), HttpStatus.ACCEPTED);
        } catch (AssessmentsAlreadyExistsException exception) {
            System.out.println("Assignment id already exist");
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/assignment/{batchId}/{assignmentId}")
    public ResponseEntity<List<AssignmentQuestion>> getAssignmentByAssignmentIdAndBatchId(@PathVariable("assignmentId") String assignmentId, @PathVariable("batchId") String batchId) throws AssessmentsNotFoundException {
        System.out.println("batchId:" + batchId + " assignment:" + assignmentId);
        return new ResponseEntity<List<AssignmentQuestion>>(service.getAssignmentByAssignmentIdAndBatchId(assignmentId, batchId),HttpStatus.OK);
    }

    @GetMapping("/assignments/{batchId}")
    public ResponseEntity<List<Assignment>> getAllAssignmentsByBatchId(@PathVariable("batchId") String batchId) throws AssessmentsNotFoundException {

        try {
            return new ResponseEntity<List<Assignment>>(service.getAllAssignmentsByBatchId(batchId),HttpStatus.FOUND);
        } catch (AssessmentsNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/assessment/pending-assignments/{batchId}")
//    public ResponseEntity<List<Assignment>> getAllPendingAssignmentsForLearner(@PathVariable("batchId") String batchId) throws AssessmentsNotFoundException {
//        return new ResponseEntity<List<Assignment>>(service.getAllPendingAssignmentsForLearner(batchId), HttpStatus.FOUND);
//    }
//
//    @GetMapping("/assessment/completed-assignments/{batchId}")
//    public ResponseEntity<List<Assignment>> getAllCompletedAssignmentsForLearner(@PathVariable("batchId") String batchId) throws AssessmentsNotFoundException {
//        return new ResponseEntity<List<Assignment>>(service.getAllCompletedAssignmentsForLearners(batchId), HttpStatus.FOUND);
//    }

    @PostMapping("/updateAssignment/{batchId}/{assignmentId}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable("batchId") String batchId, @PathVariable("assignmentId") String assignmentId, @RequestBody Assignment assignment) throws BatchIdNotFoundException, AssessmentsNotFoundException {
        return new ResponseEntity<Assignment>(service.updateAssignment(batchId, assignmentId, assignment),HttpStatus.CREATED);
    }

    @GetMapping("/batches")
    public ResponseEntity<List<AssessmentGeneration>> getAllBatchesData() throws NoDataFoundException {
        return new ResponseEntity<List<AssessmentGeneration>>(service.getAllBatchesData(), HttpStatus.FOUND);
    }

    @DeleteMapping("/batches/{batchId}")
    public ResponseEntity<List<AssessmentGeneration>> givenBatchIdShouldDeleteTheAssessmentGeneration(@PathVariable("batchId") String batchId) throws BatchIdNotFoundException {
        return new ResponseEntity<List<AssessmentGeneration>>(service.givenBatchIdShouldDeleteTheAssessmentGeneration(batchId),HttpStatus.GONE);
    }

    @DeleteMapping("/deleteAssignment/{batchId}/{assignmentId}")
    public ResponseEntity<AssessmentGeneration> givenBatchIdAndAssignmentShouldDeleteTheAssignment(@PathVariable("batchId") String batchId, @PathVariable("assignmentId") String assignmentId) throws BatchIdNotFoundException,AssessmentsNotFoundException {
        return new ResponseEntity<AssessmentGeneration>(service.givenBatchIdAndAssignmentShouldDeleteTheAssignment(batchId,assignmentId),HttpStatus.GONE);
    }
    @PostMapping("/addQuestions/{batchId}/{assignmentId}")
    public ResponseEntity<Assignment> addQuestions(@PathVariable("batchId") String batchId, @PathVariable("assignmentId") String assignmentId, @RequestBody AssignmentQuestion assignmentQuestions) throws BatchIdNotFoundException, AssessmentsNotFoundException {
        return new ResponseEntity<Assignment>(service.addQuestionsInAssignment(batchId, assignmentId, assignmentQuestions), HttpStatus.ACCEPTED);
    }

    @PostMapping("/learnerAnswer/{batchId}/{assignmentId}/{questionId}")
    public ResponseEntity<?> addLearnerAnswer(@PathVariable("batchId") String batchId, @PathVariable("assignmentId") String assignmentId, @PathVariable("questionId") Integer questionId, @RequestBody LearnerAnswer learnerAnswer) throws BatchIdNotFoundException, AssessmentsNotFoundException {
        service.addLearnerAnswer(batchId, assignmentId, questionId, learnerAnswer);
        return new ResponseEntity<>("Answer added", HttpStatus.OK);
    }

//    @GetMapping("/getQuestions/{batchId}/{assignmentId}")
//    public ResponseEntity<?> getAssignmentQuestions(@PathVariable("batchId") String batchId, @PathVariable("assignmentId") String assignmentId) {
//        return new ResponseEntity<>(service.getAssignmentByAssignmentIdAndBatchId())
//    }

    @GetMapping("/getAssessment/{email}")
    public ResponseEntity<?> getAssessmnet(@PathVariable("email") String email) {
        return new ResponseEntity<>(service.getAssessment(email), HttpStatus.OK);
    }

    @GetMapping("/getAssignment/{email}")
    public ResponseEntity<?> getAllAssignment(@PathVariable("email") String email) {
        return new ResponseEntity<>(service.getAssignment(email), HttpStatus.OK);
    }
}
