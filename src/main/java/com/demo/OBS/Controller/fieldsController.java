package com.demo.OBS.Controller;

import com.demo.OBS.Dao.DaoUsers;
import org.springframework.mail.javamail.JavaMailSender;
import com.demo.OBS.Model.*;
import com.demo.OBS.Service.AdminService;
import com.demo.OBS.Service.CentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class fieldsController {

    @Autowired
    CentersService centersService;
    @Autowired
    AdminService adminService;
    @Autowired
    JavaMailSender javaMailSender;


    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    List<Timetable> timetable = new ArrayList<>();
    public Date converter(String s){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateInString = s;
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(date);
        //System.out.println(formatter.format(date));
        return date;
    }

    @GetMapping(value = "/showTimetables")
    public Response getResource() {
        Response response = new Response("Done" , timetable);
        return response;
    }

    @RequestMapping(value = "/getDataForTimetable")
    public Response getDataForTimetable(@RequestParam int field_id,@RequestParam int dayId) {
        System.out.println("fieldId:"+field_id+" , DayId:"+dayId);
        timetable = new ArrayList<>();
        List<Day> week = centersService.getWeek();
        String s_date = "";
        for(Day d: week){
            if(dayId == d.getId()){
                s_date=d.getFullDate();
            }
        }
        Date date = converter(s_date);
        timetable = centersService.getTimetable(date,field_id);
        Response response = new Response("Done", timetable);
        return response;
    }

    @RequestMapping("/booking")
    public Response booking(){
        System.out.println("timetable is taken");
        System.out.println(timetable);
        Response response = new Response("Done" , timetable);
        return response;
    }

    @RequestMapping("/sendCheckedTimeIdToController")
    public String sendCheckedTimeIdToController(@RequestParam("time[]") List<String> timeId, @RequestParam int fieldId,
                                                @RequestParam String day, Authentication auth) throws MessagingException {
        List<Day> week = centersService.getWeek();
        String stringDate = "";
        for(Day d: week){
            if(Integer.parseInt(day) == d.getId()){
                stringDate=d.getFullDate();
            }
        }
        Date date = converter(stringDate);
        System.out.println(date);
        Booked book = new Booked();

        Users user = centersService.getUserByUsername(auth.getName());
        for (String t:timeId) {
            Booked booked = new Booked(fieldId, user.getId(), date, Integer.parseInt(t));
            centersService.book(booked);
        }
        System.out.println("booked");

        //==================================== Email sending ==================================================

        System.out.println(4);
        return "/";
    }
/*
    void sendEmail(String to ,String subject, String text){
        System.out.println(1);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        System.out.println(2);
        try {
            System.out.println(3);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText("text");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error in massage sending");
        }



    }

*/
}
