package com.demo.OBS.Service;

import com.demo.OBS.Dao.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.OBS.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CentersImp implements CentersService{

    @Autowired
    private DaoCenters daoCenters;
    @Autowired
    private DaoFields daoFields;
    @Autowired
    private DaoBooked daoBooked;
    @Autowired
    private DaoTime daoTime;
    @Autowired
    DaoLocation daoLocation;
    @Autowired
    DaoUsers daoUsers;

    @Override
    public List<Centers> findAllCenters(){
        List<Centers> list = daoCenters.findAllBy();
        return list;
    }


    @Override
    public List<Fields> findFieldsByCenterId(int id){
        List<Fields> list = daoFields.findAll();
        List<Fields> list1 = new ArrayList<>();
        for(Fields f : list){
            if(f.getCenterId()==id){
                list1.add(f);
            }
        }
        return  list1;
    }


    @Override
    public List<Location> findLocations(){
        List<Location> list = daoLocation.findAllBy();
        return list;
    }

    @Override
    public Centers findCentersById(int id){
        Centers center = daoCenters.findCentersById(id);
        return center;
    }

    @Override
    public String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime localDateTime= LocalDateTime.now();
        //System.out.println(formatter.format(localDateTime));
        return formatter.format(localDateTime);
    }

    @Override
    public String getCurrentDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime= LocalDateTime.now();
        //System.out.println(formatter.format(localDateTime));
        return formatter.format(localDateTime);
    }



    @Override
    public List<Day> getWeek(){
        List<Day> week = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
        DateTimeFormatter formatterFull = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime today = LocalDateTime.now();
        String now= formatter.format(today);
        String full = formatterFull.format(today);
        week.add(new Day(1, now, full));
        for( int i=2 ; i<8 ; i++){
            LocalDateTime next = today.plusDays(1);
            LocalDateTime nextFull = today.plusDays(1);
            week.add(new Day(i, next.format(formatter), nextFull.format(formatterFull)));
            today = next;
        }
        return week;
    }

    @Override
    public List<Time> findAllTime(){
        List<Time> list = daoTime.findAllBy();
        return list;
    }

    @Override
    public List<Timetable> getTimetable(Date date , int field_id ){
        List<Booked> booked = daoBooked.getBookedsByFieldIdAndTheDate(field_id ,date);
        List<Time> times = daoTime.findAllBy();
        List<Timetable> timetables = new ArrayList<>();
        if(booked.size()==0) {
            for (Time time : times) {
                Timetable timetable = new Timetable(time.getId(), field_id, date, time.getTime(), "free");
                timetables.add(timetable);
            }
        }
        else {
            for (Time time : times) {
                int counter = 1;
                for (Booked b : booked) {
                    if (time.getId() == b.getTimeId()) {
                        Timetable timetable = new Timetable(time.getId(), field_id, date, time.getTime(), "busy");
                        timetables.add(timetable);
                        break;
                    }
                    if (counter == booked.size()) {
                        Timetable timetable1 = new Timetable(time.getId(), field_id, date, time.getTime(), "free");
                        timetables.add(timetable1);
                    }
                    counter++;
                }
            }
        }
        return timetables;
    }

    @Override
    public void book(Booked book) {
        daoBooked.save(book);
    }

    @Override
    public Users getUserByUsername(String username) {
        Users user  = daoUsers.findUsersByUsername(username);
        return user;
    }

    /*
    @Override
    public String getUsernameOfLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
    */


}
