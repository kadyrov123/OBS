package com.demo.OBS.Service;

import com.demo.OBS.Model.Fields;


public interface AdminService {
    void addNewField(Fields f);
    void deleteField(int fieldId);

    void changePriceOfField(int fieldId , int price);
    void changeFieldAtrribute();

    int getAdminsCenterId(String username);
}
