package com.stackroute.authenticationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.authenticationservice.config.JwtTokenGenerator;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.repository.UserRepository;
import com.stackroute.authenticationservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private JwtTokenGenerator jwtTokenGenerator;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void givenEmptyUserValuesShouldReturnEmptyFieldErrorMessage() throws Exception{
        User userObject = new User("shekhar@gmail.com","shekhar12345","Learner");
        when(userService.getUserByEmailId("shekhar@gmail.com")).thenReturn(userObject);
        //when(userRepository.save(any())).thenReturn(userObject);
        userRepository.save(userObject);
        mockMvc.perform(get("/api/v1/login/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"emailId\":\"shekhar@gmail.com\",\"password\":\"shekhar12345\",\"role\":\"Learner\"}"))
                .andExpect(status().isOk());

    }

}