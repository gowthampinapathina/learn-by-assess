package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.exception.UserAlreadyExistException;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.model.User;

public interface UserService {

    public User getUserByEmailId(String emailId) throws UserNotFoundException;
    public User createUser(User user) throws UserAlreadyExistException;
}
