package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.exception.UserAlreadyExistException;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    @Value("${app.service.message1}")
    private String userNotFoundMessage;

    @Value("${app.service.message2}")
    private String userAlreadyExistMessage;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmailId(String emailId) throws UserNotFoundException {
        Optional<User> userObject = userRepository.findById(emailId);
        if(userObject.isPresent()){
            return userObject.get();
        } else{

            throw new UserNotFoundException(userNotFoundMessage);
        }
    }

    @Override
    public User createUser(User user) throws UserAlreadyExistException {
        Optional<User> newUser = userRepository.findById(user.getEmailId());
        if (newUser.isPresent()){
            throw  new UserAlreadyExistException(userAlreadyExistMessage);
        }
        return userRepository.save(user);
    }
}
