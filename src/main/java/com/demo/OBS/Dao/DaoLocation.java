package com.demo.OBS.Dao;

import com.demo.OBS.Model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaoLocation extends CrudRepository<Location,Long> {
    List<Location> findAllBy();
}
