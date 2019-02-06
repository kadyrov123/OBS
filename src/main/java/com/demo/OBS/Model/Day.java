package com.demo.OBS.Model;

public class Day {
    private int id;
    private String day;
    private String fullDate;


    public Day(int id, String day, String fullDate) {
        this.id = id;
        this.day = day;
        this.fullDate = fullDate;
    }
    public Day() { }

    public Day(int id, String day) {
        this.id = id;
        this.day = day;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFullDate() {
        return fullDate;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }
}
