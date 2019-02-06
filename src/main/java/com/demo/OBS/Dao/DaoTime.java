package com.demo.OBS.Dao;

import com.demo.OBS.Model.Time;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaoTime extends CrudRepository<Time , String> {
    List<Time> findAllBy();

}
