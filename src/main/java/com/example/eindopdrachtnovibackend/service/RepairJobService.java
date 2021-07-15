package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.controller.dto.RepairDto;
import com.example.eindopdrachtnovibackend.model.RepairJob;

import java.util.List;

    public interface RepairJobService {
        List<RepairJob> getRepairJob();
        RepairJob getRepairJob(long id);
        RepairJob addRepairJob(RepairDto repairDto);
        void removeRepairJob(long id);
        void updateRepairJob(long id, RepairJob repairJob);
        List<RepairJob> getByCustomerAgrees(String customerAgrees);

//        Customer getByFirstName(String firstname);
//        Customer getByPhoneNumber(Integer phoneNumber);

    }


