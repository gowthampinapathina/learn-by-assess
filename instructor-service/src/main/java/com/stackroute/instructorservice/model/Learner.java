package com.stackroute.instructorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Learner {
    private String emailId;
    private String firstName;
    private String lastName;
    private String mobNo;
    private String gender;
    private int age;
    private String profile_pic_url;
    private List<Assessment> attemptedAssessment;
    private List<Assessment> pendingAssessment;


    @Override
    public String toString() {
        return "Learner{" +
                "emailId='" + emailId + '\'' +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", mobile_num='" + mobNo + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", profile_pic_url='" + profile_pic_url + '\'' +
                ", attemptedAssessment=" + attemptedAssessment +
                ", pendingAssessment=" + pendingAssessment +
                '}';
    }
}

