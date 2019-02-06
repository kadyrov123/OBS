package com.demo.OBS;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {


    static BCryptPasswordEncoder b = new BCryptPasswordEncoder();
    public static void main(String[] args) {


        System.out.println(b.encode("user1"));
        System.out.println(b.encode("user2"));
        System.out.println(b.encode("admin"));

        /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime= LocalDateTime.now();
        System.out.println(formatter.format(localDateTime));

        localDateTime.plusDays(1);
        LocalDateTime today = localDateTime.plusDays(1);
        System.out.println(formatter.format(today));

        Date date = new Date();
        System.out.println(date.toString());
        //System.out.println(b.encode("b"));
        */
    }


}
