package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.model.RepairItem;


import java.util.List;

public interface RepairItemService {
    List<RepairItem> getRepairItem();
    RepairItem getRepairItem(long id);
    RepairItem addRepairItem(RepairItem repairItem);
    void removeRepairItem(long id);
    void updateRepairItem(long id, RepairItem repairItem);

//        Customer getByFirstName(String firstname);
//        Customer getByPhoneNumber(Integer phoneNumber);

}