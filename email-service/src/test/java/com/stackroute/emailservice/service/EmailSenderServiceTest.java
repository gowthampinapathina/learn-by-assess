package com.stackroute.emailservice.service;

import com.stackroute.emailservice.model.EmailNotification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmailSenderServiceTest {
    @InjectMocks
    private EmailSenderServiceImpl emailSenderService;

    @Test
    public void setEmailSenderService(){
        EmailNotification emailNotification = new EmailNotification("mangal.4@iitj.ac.in","Test cases" ,"Test case is passed " );


}
}