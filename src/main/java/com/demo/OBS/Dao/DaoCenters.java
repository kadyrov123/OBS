package com.demo.OBS.Dao;

import  com.demo.OBS.Model.Centers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaoCenters extends CrudRepository<Centers, Long> {
    List<Centers> findAllById(int id);
    List<Centers> findAllBy();
    Centers findCentersById(int id);
    List<Centers> findAllByLocationId(int id);

    Centers getCentersByAdminId(int id);

}
