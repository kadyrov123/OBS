package com.demo.OBS.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booked {
    private int id;
    private int fieldId;
    private int userId;
    private java.util.Date theDate;
    private int timeId;

    public Booked(int fieldId, int userId, java.util.Date theDate, int timeId) {
        this.fieldId = fieldId;
        this.userId = userId;
        this.theDate = theDate;
        this.timeId = timeId;
    }



    public Booked() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "field_id", nullable = false)
    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "the_date", nullable = false)
    public Date getTheDate() {
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    @Basic
    @Column(name = "time_id", nullable = false)
    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booked booked = (Booked) o;

        if (id != booked.id) return false;
        if (fieldId != booked.fieldId) return false;
        if (userId != booked.userId) return false;
        if (timeId != booked.timeId) return false;
        if (theDate != null ? !theDate.equals(booked.theDate) : booked.theDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fieldId;
        result = 31 * result + userId;
        result = 31 * result + (theDate != null ? theDate.hashCode() : 0);
        result = 31 * result + timeId;
        return result;
    }
    @Override
    public String toString() {
        return "Booked{" +
                "id=" + id +
                ", fieldId=" + fieldId +
                ", userId=" + userId +
                ", theDate=" + theDate +
                ", timeId=" + timeId +
                '}';
    }
}
