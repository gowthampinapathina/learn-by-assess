package com.stackroute.assessmentservice.service;

import com.stackroute.assessmentservice.exceptions.*;
import com.stackroute.assessmentservice.model.*;
import com.stackroute.assessmentservice.repository.AssessmentGenerationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssessmentGenerationServiceTest {

    @Mock
    private AssessmentGenerationRepository assessmentGenerationRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private AssessmentGenerationServiceImpl assessmentGenerationService;

    private AssessmentGeneration assessmentGeneration;
    private List<AssessmentGeneration> assessmentGenerations;
    private Optional optional;

    @BeforeEach
    public void setUp() {
//        List<Participant> participants= new ArrayList<>();
//        Participant participant = new Participant("Gowtham@gmail.com", 80, "pending");
//        participants.add(participant);
//        List<Options> optionStatus = new ArrayList<>();
//        optionStatus.add( new Options("java is a OOP Language", true));
//        optionStatus.add( new Options("java is not a OOP Language", false));
//
//        List<String> options = new ArrayList<>();
//        options.add(0, "java is a OOP Language");
//        options.add(1, "java is not a OOP Language");
//
//        List<String> rules = new ArrayList<>();
//        rules.add(0, "Complete within the timeLimit");
//        rules.add(1, "Maintain a proper network Connection");
//
//        List<GradingRubrics> levels = new ArrayList<>();
//        levels.add(0, new GradingRubrics("Level1", 5, 100, "mcq/descriptive"));
//        levels.add(1, new GradingRubrics("Level2", 3, 45, "mcq/descriptive"));
//
//
//        List<AssignmentQuestion> assignmentQuestions = new ArrayList<>();
//        assignmentQuestions.add(new AssignmentQuestion(1, "mcq", "What is Java?", "Just understand and write", "Easy", 0,
//                options, "java is a OOP Language", "java is not a OOP Language", optionStatus));
//        assignmentQuestions.add(new AssignmentQuestion(2, "mcq", "What is C++?", "Just understand and write", "Easy", 0,
//                options, "java is a OOP Language", "java is not a OOP Language", optionStatus));
//
//        List<Assignment> assignments = new ArrayList<>();
//        AssignmentTemplate assignmentTemplate =  new AssignmentTemplate("Java Basics", "CS",
//                "2016-10-06 08:34:00", "2016-10-06 10:34:00", rules, 0, "review pending",
//                "Computer Science Coding", levels, assignmentQuestions, participants);
//        assignments.add(0, new Assignment("10", "12546",assignmentTemplate));
//
//        MockitoAnnotations.initMocks(this);
//        assessmentGeneration = new AssessmentGeneration("150", "Tarun Sharma", assignments);
//        optional = Optional.of(assessmentGeneration);
    }

    @AfterEach
    public void tearDown() {
        assessmentGenerationRepository.deleteByBatchId("150");
    }

    @Test
    public void givenAssessmentGenerationToSaveShouldReturnAssessmentGeneration() throws BatchIdAlreadyExistsException , AssessmentInvalidException {
        assessmentGenerationRepository.save(assessmentGeneration);
        when(assessmentGenerationRepository.save(any())).thenReturn(assessmentGeneration);
        assessmentGenerationService.saveAssessmentGenerationForTheNewBatch(assessmentGeneration);
        verify(assessmentGenerationRepository,times(2)).save(any());
    }

    @Test
    void givenBatchIdAndAssignmentIdThenShouldReturnListOfAssignment() throws AssessmentsNotFoundException {

    }

    @Test
    void getAllAssignmentsByBatchId() {
    }

    @Test
    void getAllPendingAssignmentsForLearner() {
    }

    @Test
    void getAllCompletedAssignmentsForLearners() {
    }

    @Test
    void givenGetAllBatchesDataThenShouldReturnListOfAssessmentGeneration() throws NoDataFoundException {
        List<AssessmentGeneration> assessmentGenerationsList=new ArrayList<>();
        assessmentGenerationsList.add(assessmentGeneration);
        when(assessmentGenerationRepository.findAll()).thenReturn(assessmentGenerationsList);
        List<AssessmentGeneration> assessmentGenerationsList1= assessmentGenerationService.getAllBatchesData();
        assertNotEquals(0,assessmentGenerationsList.size());
        assertEquals(assessmentGenerationsList,assessmentGenerationsList1);
        verify(assessmentGenerationRepository,times(2)).findAll();
    }
}