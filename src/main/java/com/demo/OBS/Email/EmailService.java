package com.demo.OBS.Email;

import org.springframework.mail.MailSender;

public interface EmailService{
    void simpleMailSender(String to , String subject, String text);
}
