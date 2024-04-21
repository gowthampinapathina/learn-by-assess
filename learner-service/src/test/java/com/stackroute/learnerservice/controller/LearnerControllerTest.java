package com.stackroute.learnerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.learnerservice.model.Learner;
import com.stackroute.learnerservice.service.LearnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import org.springframework.test.web.servlet.*;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class LearnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private LearnerService learnerService;
    private Learner learner;
    private List<Learner> learnerList;

    @InjectMocks
    private LearnerController learnerController;
    @BeforeEach
    public void setUp(){
        learner = new Learner("rankadhanush99@gmail.com", "dhanush","Kumar","password",
                "7823028608","male",22,"","leaner");
        mockMvc = MockMvcBuilders.standaloneSetup(learnerController).build();
    }

    @Test
    public void givenLearnerToSaveSholudReturnSavedLearner() throws Exception{
        when(learnerService.saveLearner(any())).thenReturn(learner);
        mockMvc.perform(post("api/v1/learner")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(learner)))
                .andExpect(status().isCreated());
    }
    public static String asJsonString(final Object obj){
       try{
           return new ObjectMapper().writeValueAsString(obj);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
