package com.stackroute.authenticationservice.controller;


import com.stackroute.authenticationservice.config.JwtTokenGenerator;
import com.stackroute.authenticationservice.exception.UserAlreadyExistException;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class UserController {


    @Value("${app.controller.exception.message1}")
    private String fieldBlandMessage;


    @Value("${app.controller.exception.message2}")
    private String userNotFoundMessage;

    @Value("${app.controller.exception.message3}")
    private String invalidMessage;

    private UserService userService;
    private JwtTokenGenerator jwtTokenGenerator;

    ResponseEntity<?> responseEntity;

    @Autowired
    public UserController(UserService userService, JwtTokenGenerator jwtTokenGenerator) {
        this.userService = userService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping("login/user")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {

            if (user.getEmailId() == null || user.getPassword() == null
                    || user.getEmailId().isBlank() || user.getPassword().isBlank()) {
                throw new UserNotFoundException(fieldBlandMessage);
            }

            User userObject = userService.getUserByEmailId(user.getEmailId());
            if (userObject == null) {
                throw new UserNotFoundException(userNotFoundMessage);
            }

            if (!(user.getPassword().equals(userObject.getPassword()))) {
                throw new UserNotFoundException(invalidMessage);
            }
            responseEntity = new ResponseEntity<>(jwtTokenGenerator.generateToken(userObject), HttpStatus.OK);

        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("register/user")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.createUser(user);
            responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}

