package com.demo.OBS.Dao;

import com.demo.OBS.Model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaoUsers extends CrudRepository<Users, Long> {
    Users findAllBy();
    List<Users> findAllByUsername(String username);
    Users findUsersByUsername(String username);
    Users findUsersByRoleContains(String role);



}
