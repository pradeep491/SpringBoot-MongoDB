package com.test.controller;

import com.test.service.MailSenderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail/")
public class MailController {

    private final MailSenderService service;


    public MailController(MailSenderService service) {
        this.service = service;
    }
    //http://localhost:8080/mail/send?toEmail=k.pradeep0491@gmail.com&subject=SpringBoot Mail Test&body=Hello Punnu Jasvin
    @GetMapping("/send")
    public String sendMail(@RequestParam("toEmail") String toMail,
                           @RequestParam("subject") String subject,
                           @RequestParam("body") String body) {
        service.sendMail(toMail, subject, body);
        return "successfully sent the email...!";
    }
}
