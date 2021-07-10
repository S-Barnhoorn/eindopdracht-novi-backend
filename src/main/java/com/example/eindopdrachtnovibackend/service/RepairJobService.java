package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.model.RepairJob;

import java.util.List;

    public interface RepairJobService {
        List<RepairJob> getRepairJob();
        RepairJob getRepairJob(long id);
        RepairJob addRepairJob(RepairJob repairJob);
        void removeRepairJob(long id);
        void updateRepairJob(long id, RepairJob repairJob);
        RepairJob getByCustomerAgrees(String customerAgrees);

//        Customer getByFirstName(String firstname);
//        Customer getByPhoneNumber(Integer phoneNumber);

    }


