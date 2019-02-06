package com.demo.OBS.Service;

import com.demo.OBS.Dao.DaoCenters;
import com.demo.OBS.Dao.DaoFields;
import com.demo.OBS.Dao.DaoUsers;
import com.demo.OBS.Model.Centers;
import com.demo.OBS.Model.Fields;
import com.demo.OBS.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Repository
public class AdminServiceImp implements AdminService {
    @Autowired
    DaoFields daoFields;
    @Autowired
    DaoUsers daoUsers;
    @Autowired
    DaoCenters daoCenters;

    @Override
    public void addNewField(Fields f) {
        daoFields.save(f);
    }

    @Override
    public void deleteField(int fieldId) {
        daoFields.deleteAllById(fieldId);
    }

    @Override
    public void changePriceOfField(int fieldId, int price) {

    }

    @Override
    public void changeFieldAtrribute() {

    }

    @Override
    public int getAdminsCenterId(String username) throws UsernameNotFoundException {
        Users user = daoUsers.findUsersByUsername(username);
        int id = user.getId();
        Centers center = daoCenters.getCentersByAdminId(id);
        int centerId = center.getId();
        return centerId;
    }
}
