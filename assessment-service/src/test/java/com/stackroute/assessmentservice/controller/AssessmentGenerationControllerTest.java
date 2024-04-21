//package com.stackroute.assessmentservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.assessmentservice.exceptions.AssessmentsAlreadyExistsException;
//import com.stackroute.assessmentservice.exceptions.BatchIdAlreadyExistsException;
//import com.stackroute.assessmentservice.exceptions.GlobalExceptionHandler;
//import com.stackroute.assessmentservice.model.*;
//import com.stackroute.assessmentservice.service.AssessmentGenerationService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//class AssessmentGenerationControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private AssessmentGenerationService assessmentGenerationService;
//
//    @InjectMocks
//    private AssessmentGenerationController assessmentGenerationController;
//
//    private AssessmentGeneration assessmentGeneration;
//    private List<AssessmentGeneration> assessmentGenerationList;
//    private List<Assignment> assignments;
//
//    public AssessmentGeneration getAssessmentGeneration() {
//        List<Participant> participants = new ArrayList<>();
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
//        assignments = new ArrayList<>();
//        AssignmentTemplate assignmentTemplate =  new AssignmentTemplate("Java Basics", "CS",
//                "2016-10-06 08:34:00", "2016-10-06 10:34:00", rules, 0, "review pending",
//                "Computer Science Coding", levels, assignmentQuestions, participants);
//        assignments.add(0, new Assignment("10", "12546",assignmentTemplate));
//        this.assessmentGeneration = new AssessmentGeneration("150", "Tarun Sharma", assignments);
//        return this.assessmentGeneration;
//    }
//
//    public List<Assignment> getAssignments() {
//        List<Participant> participants = new ArrayList<>();
//        Participant participant = new Participant("Gowtham@gmail.com", 80, "pending");
//        participants.add(participant);
//
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
//        assignments = new ArrayList<>();
//        AssignmentTemplate assignmentTemplate =  new AssignmentTemplate("Java Basics", "CS",
//                "2016-10-06 08:34:00", "2016-10-06 10:34:00",  rules, 0, "review pending",
//                "Computer Science Coding", levels, assignmentQuestions, participants);
//        assignments.add(0, new Assignment("10", "12546",assignmentTemplate));
//        return assignments;
//    }
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(assessmentGenerationController).setControllerAdvice(new GlobalExceptionHandler()).build();
//        List<Participant> participants = new ArrayList<>();
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
//        assignments = new ArrayList<>();
//        AssignmentTemplate assignmentTemplate =  new AssignmentTemplate("Java Basics", "CS",
//                "2016-10-06 08:34:00", "2016-10-06 10:34:00", rules, 0, "review pending",
//                "Computer Science Coding", levels, assignmentQuestions, participants);
//        assignments.add(0, new Assignment("10", "12546",assignmentTemplate));
//        assessmentGeneration = new AssessmentGeneration("150", "Tarun Sharma", assignments);
//        assessmentGenerationList = new ArrayList<>();
//        assessmentGenerationList.add(assessmentGeneration);
//    }
//
//    @AfterEach
//    void teardown() {
//        assessmentGeneration=null;
//        assessmentGenerationList.clear();
//    }
//
//    @Test
//    public void givenAssessmentGenerationToSaveThenShouldReturnSavedAssessmentGeneration() throws Exception,AssessmentsAlreadyExistsException {
//        when(assessmentGenerationService.saveAssessmentGenerationForTheNewBatch(any())).thenReturn(assessmentGeneration);
//        mockMvc.perform(post("/api/v1/new_batch_assessment")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(assessmentGeneration)))
//                .andExpect(status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    void givenAssessmentGenerationToSaveThenShouldNotReturnSavedAssessmentGeneration() throws Exception {
//        when(assessmentGenerationService.saveAssessmentGenerationForTheNewBatch(any())).thenThrow(BatchIdAlreadyExistsException.class);
//        mockMvc.perform(post("/api/v1/new_batch_assessment")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(assessmentGeneration)))
//                .andExpect(status().isAlreadyReported())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
////    @Test
////    void givenBatchIdAndAssignmentIdShouldReturnAssignmentInThatBatchId() throws Exception {
////        when(assessmentGenerationService.getAssignmentByAssignmentIdAndBatchId("10","150")).thenReturn(assignments);
////        mockMvc.perform(MockMvcRequestBuilders.get("/assessment/{batchId}/{assignmentId}")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(asJsonString(assessmentGeneration)))
////                        .andExpect(status().isFound())
////                        .andDo(MockMvcResultHandlers.print());
////    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}