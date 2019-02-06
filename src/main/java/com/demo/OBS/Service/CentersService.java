package com.demo.OBS.Service;

import com.demo.OBS.Model.*;

import java.util.Date;
import java.util.List;

public interface CentersService {
    List<Centers> findAllCenters();
    Centers findCentersById(int id);

    String getCurrentDate();
    String getCurrentDate(String format);

    List<Day> getWeek();

    List<Fields> findFieldsByCenterId(int id);

    List<Location> findLocations();

    List<Time> findAllTime();

    List<Timetable> getTimetable(Date date, int field_id);

    void book(Booked booked);

    //String getUsernameOfLoggedInUser();

    Users getUserByUsername(String username);

}
