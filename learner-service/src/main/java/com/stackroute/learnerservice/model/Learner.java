package com.stackroute.learnerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="learners")
public class Learner {
    @Id
    private String emailId;
    private String firstName;
    private String lastName;
    private String password;
    private String mobNo;
    private String gender;
    private int age;
    private String profile;
    private String role ="Learner";
}
