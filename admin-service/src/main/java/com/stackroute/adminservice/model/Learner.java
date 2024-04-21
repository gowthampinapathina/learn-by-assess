package com.stackroute.adminservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Learner {
    private String emailId;
    private String password;
    private String firstName;
    private String lastName;
    private String mobNo;
    private String gender;
    private int age;
    private String profile_pic_url;
    private List<Assessment>attemptedAssessment;
    private List<Assessment>pendingAssessment;


}
