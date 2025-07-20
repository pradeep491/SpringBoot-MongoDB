package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    private final JavaMailSender sender;

    public MailSenderService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendMail(String toEmail, String subject, String body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        simpleMailMessage.setFrom("hello@demomailtrap.com");

        sender.send(simpleMailMessage);
    }
}
