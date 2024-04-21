package com.stackroute.emailservice.service;

import com.stackroute.emailservice.exception.EmailNotFoundException;
import com.stackroute.emailservice.model.EmailNotification;

public interface EmailSenderService {
    public void sendEmail(EmailNotification emailNotification) throws EmailNotFoundException;
}
