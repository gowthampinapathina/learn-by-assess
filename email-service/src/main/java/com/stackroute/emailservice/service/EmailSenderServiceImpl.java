package com.stackroute.emailservice.service;

import com.stackroute.emailservice.model.EmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    @Autowired
    private MailSender mailSender;
    @Override
    public void sendEmail(EmailNotification emailNotification){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ankitmangal058@gmail.com");
        message.setTo(emailNotification.getToReceiptent());
        message.setText(emailNotification.getBody());
        message.setSubject(emailNotification.getSubject());
        mailSender.send(message);
        System.out.println("Mail sent successfully....");
    }
    /*public void sendEmail(String to,
                          String subject,
                          String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ankitmangal058@gmail.com");
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail sent successfully....");



    }*/




}
