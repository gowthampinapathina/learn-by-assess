package com.stackroute.emailservice.Controller;

import com.stackroute.emailservice.exception.EmailNotFoundException;
import com.stackroute.emailservice.model.EmailNotification;
import com.stackroute.emailservice.service.EmailSenderService;
import com.stackroute.emailservice.service.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
    private EmailSenderService emailSenderService;

    @Autowired
    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/email")
    public void sendEmail(@RequestBody EmailNotification emailNotification) throws EmailNotFoundException {
        emailSenderService.sendEmail(emailNotification);
    }
    @GetMapping("/getMessage")
    public String getMessage(){
        return "Get is working properly";
    }

}
