package com.stackroute.instructorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InstructorServiceApplication {

	public static void main(String[] args) 	{
		SpringApplication.run(InstructorServiceApplication.class, args);
	}

}
