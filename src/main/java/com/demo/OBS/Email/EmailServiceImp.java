package com.demo.OBS.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImp {

    @Autowired
    public JavaMailSender mailSender;

    public void  simpleMailSender(String to , String subject, String text){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        mailSender.send(simpleMailMessage);

    }

}
