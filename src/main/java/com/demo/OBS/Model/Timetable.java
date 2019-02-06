package com.demo.OBS.Model;

import java.util.Date;
import java.util.List;

public class Timetable {
    private int id;
    private int fields_id;
    private Date date;
    private String time;
    private String isFree;

    public Timetable(int id, int fields_id, Date date, String time, String isFree) {
        this.id = id;
        this.fields_id = fields_id;
        this.date = date;
        this.time = time;
        this.isFree = isFree;
    }

    public Timetable(Date date , int fields_id){
        this.date=date;
        this.fields_id=fields_id;
    }

    public Timetable() {
    }

    public int getFields_id() {
        return fields_id;
    }

    public void setFields_id(int fields_id) {
        this.fields_id = fields_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", fields_id=" + fields_id +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", isFree='" + isFree + '\'' +
                '}';
    }
}
