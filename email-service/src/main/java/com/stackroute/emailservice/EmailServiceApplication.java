package com.stackroute.emailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration
public class EmailServiceApplication {



    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);

    }
    /*@EventListener(ApplicationReadyEvent.class)
    public  void sendMail(){
        senderService.sendEmail("mangal.4@iitj.ac.in", "This is subject" , "This is body of the email");
    }*/

}
