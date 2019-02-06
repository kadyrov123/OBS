package com.demo.OBS.Dao;

import com.demo.OBS.Model.Fields;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DaoFields extends CrudRepository<Fields,Integer> {
    List<Fields> findAll();

    <S extends Fields> S save(S s);

    void deleteAllById(int id);


}
