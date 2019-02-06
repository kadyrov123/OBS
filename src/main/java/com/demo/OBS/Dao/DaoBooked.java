package com.demo.OBS.Dao;

import com.demo.OBS.Model.Booked;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface DaoBooked extends CrudRepository<Booked , Integer>{
    List<Booked> getBookedsByFieldIdAndTheDate(int field_id , Date date);

    <S extends Booked> S save(S s);
}
