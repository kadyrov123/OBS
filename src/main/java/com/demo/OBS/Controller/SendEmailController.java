package com.demo.OBS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.ws.Action;

@RestController
public class SendEmailController {
    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping("/sendEmail")
    public String  sendEmail(){

        String text = "Yo have booked the field "+1+" , in 12/12/12 , time 12:00-14:00 /n thank u for booking";
        String from = "nuriddin.kadyrov@iaau.edu.kg";
        String to ="n.kadyrov123@gmail.com";
        String subject = "Booking fields";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        System.out.println(2);
        try {
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            mimeMessageHelper.setFrom(from);
            System.out.println(3);
        } catch (MessagingException e) {
            System.out.println("Error in massage sending");
        }
        javaMailSender.send(mimeMessage);

        return "Sending email !!!";
    }


}
