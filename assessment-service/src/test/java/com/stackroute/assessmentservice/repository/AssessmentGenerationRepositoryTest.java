//package com.stackroute.assessmentservice.repository;
//
//import com.stackroute.assessmentservice.model.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//class AssessmentGenerationRepositoryTest {
//
//    @Autowired
//    private AssessmentGenerationRepository assessmentGenerationRepository;
//
//    public AssessmentGeneration getAssessmentGeneration1() {
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
//        List<Assignment> assignments = new ArrayList<>();
//        AssignmentTemplate assignmentTemplate =  new AssignmentTemplate("Java Basics", "CS",
//                "2016-10-06 08:34:00", "2016-10-06 10:34:00", rules, 0, "review pending",
//                "Computer Science Coding", levels, assignmentQuestions, participants);
//        assignments.add(0, new Assignment("10", "12546",assignmentTemplate));
//        return new AssessmentGeneration("128","Gowtham",assignments);
//    }
//
//    public AssessmentGeneration getAssessmentGeneration2() {
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
//        List<Assignment> assignments = new ArrayList<>();
//        AssignmentTemplate assignmentTemplate =  new AssignmentTemplate("Java Basics", "CS",
//                "2016-10-06 08:34:00", "2016-10-06 10:34:00", rules, 0, "review pending",
//                "Computer Science Coding", levels, assignmentQuestions, participants);
//        assignments.add(0, new Assignment("10", "12546",assignmentTemplate));
//        return new AssessmentGeneration("130","SaiRam",assignments);
//    }
//
//    public AssessmentGeneration getAssessmentGeneration3() {
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
//        List<Assignment> assignments = new ArrayList<>();
//        AssignmentTemplate assignmentTemplate =  new AssignmentTemplate("Java Basics", "CS",
//                "2016-10-06 08:34:00", "2016-10-06 10:34:00", rules, 0, "review pending",
//                "Computer Science Coding", levels, assignmentQuestions, participants);
//        assignments.add(0, new Assignment("10", "12546",assignmentTemplate));
//        return new AssessmentGeneration("131","Vyas",assignments);
//    }
//    @AfterEach
//    void teardown() {
//        assessmentGenerationRepository.deleteByBatchId(getAssessmentGeneration1().getBatchId());
//        assessmentGenerationRepository.deleteByBatchId(getAssessmentGeneration2().getBatchId());
//        assessmentGenerationRepository.deleteByBatchId(getAssessmentGeneration3().getBatchId());
//    }
//
//    @Test
//    public void givenAssessmentGenerationToSaveShouldReturnAssessmentGeneration() {
//        AssessmentGeneration assessmentGeneration= new AssessmentGenerationRepositoryTest().getAssessmentGeneration3();
//        assessmentGenerationRepository.save(assessmentGeneration);
//        AssessmentGeneration assessmentGeneration1= assessmentGenerationRepository.findByBatchId(assessmentGeneration.getBatchId()).get();
//        assertNotNull(assessmentGeneration1);
//        assertEquals(assessmentGeneration.getInstructorName(),assessmentGeneration1.getInstructorName());
//    }
//
//    @Test
//    public void givenGetAllAssessmentGenerationsThenShouldReturnListOfAllAssessmentGenerations() {
//        AssessmentGeneration assessmentGeneration1 = new AssessmentGenerationRepositoryTest().getAssessmentGeneration1();
//        AssessmentGeneration assessmentGeneration2 = new AssessmentGenerationRepositoryTest().getAssessmentGeneration2();
//        assessmentGenerationRepository.save(assessmentGeneration1);
//        assessmentGenerationRepository.save(assessmentGeneration2);
//        List<AssessmentGeneration> assessmentGenerations = assessmentGenerationRepository.findAll();
//        int size = assessmentGenerations.size();
//        assertEquals("SaiRam",assessmentGenerations.get(size-1).getInstructorName());
//    }
//
//    @Test
//    public void givenBatchIdThenShouldReturnRespectiveAssessmentGeneration() {
//        AssessmentGeneration assessmentGeneration1 = new AssessmentGenerationRepositoryTest().getAssessmentGeneration1();
//        assertEquals("128",assessmentGeneration1.getBatchId());
//    }
//}