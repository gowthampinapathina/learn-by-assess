package com.stackroute.authenticationservice.repository;

import com.stackroute.authenticationservice.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUserToSaveGivenUser(){
        User user = new User("ashish@gmail.com","password","Learner");
        userRepository.save(user);
        User userObject = userRepository.findById(user.getEmailId()).get();
        assertNotNull(userObject);
        assertEquals(userObject.getEmailId(),user.getEmailId());
    }

    @Test
    public void givenListOfUserShouldReturnAllUsers(){
        User user1 = new User("ramesh@gmail.com","pass123","Instructor");
        User user2 = new User("saurav@gmail.com","saurav123","Learner");
        User user3 = new User("lokesh@gmail.com","loki123","Instructor");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        List<User> userList = userRepository.findAll();
        for (User users : userList){
            if(users.getEmailId().equals("lokesh@gmail.com")){
                assertEquals("Instructor",users.getRole());
            }
        }

    }
}