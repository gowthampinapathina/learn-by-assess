package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImplementation userServiceImplementation;

    @Test
    public void givenAValidEmailIdShouldReturnValidUser() throws UserNotFoundException {
        User user1 = new User("ramesh@gmail.com","pass123","Instructor");

        Optional<User> optionalUser = Optional.of(user1);
        when(userRepository.findById("ramesh@gmail.com")).thenReturn(optionalUser);
        User retrivedUser = userServiceImplementation.getUserByEmailId("ramesh@gmail.com");
        assertEquals(retrivedUser.getEmailId(),user1.getEmailId());
    }

    @Test
    public void givenAnInvalidUserShouldReturnException() throws UserNotFoundException{
        Optional<User> optionalUser = Optional.empty();
        when(userRepository.findById("xyz@gmail.com")).thenReturn(optionalUser);
        assertThrows(UserNotFoundException.class,()->{
            userServiceImplementation.getUserByEmailId("xyz@gmail.com");
        });
    }


}