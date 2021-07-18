package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.controller.dto.RepairDto;
import com.example.eindopdrachtnovibackend.exception.RecordNotFoundException;
import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.model.RepairItem;
import com.example.eindopdrachtnovibackend.model.RepairJob;
import com.example.eindopdrachtnovibackend.repository.CustomerRepository;
import com.example.eindopdrachtnovibackend.repository.RepairItemRepository;
import com.example.eindopdrachtnovibackend.repository.RepairJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairJobServiceImpl implements RepairJobService {
    private RepairJobRepository repairJobRepository;

    @Autowired
    public RepairJobServiceImpl(RepairJobRepository repairJobRepository) {
        this.repairJobRepository = repairJobRepository;
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RepairItemRepository repairItemRepository;



    @Override
    public List<RepairJob> getRepairJob() {
        return repairJobRepository.findAll();

    }

    @Override
    public RepairJob getRepairJob(long id) {
        Optional<RepairJob> repairJob = repairJobRepository.findById(id);
        if (repairJob.isPresent()) {
            return repairJob.get();
        } else {
            throw new RecordNotFoundException("Person does not exist");
        }
    }

    @Override
    public List<RepairJob> getByCustomerAgrees(String customerAgrees) {
        List<RepairJob> optionalRepairJob = repairJobRepository.findRepairJobsByCustomerAgrees(customerAgrees);
        return optionalRepairJob;
    }

    @Override
    public List<RepairJob> getByRepairStatus(String repairStatus) {
        List<RepairJob> optionalRepairJob = repairJobRepository.findRepairJobsByRepairStatus(repairStatus);
        return optionalRepairJob;
    }

@Override
public RepairJob addRepairJob (RepairDto repairDto){
    RepairJob repairJob = RepairDto.toRepairJob(repairDto);
    repairJob.setExamination(repairDto.getExamination());
    repairJob.setCustomerAgrees(repairDto.getCustomerAgrees());
    repairJob.setRepairStatus(repairDto.getRepairStatus());
    Customer customer = customerRepository.findById(repairDto.getCustomerId()).orElse(null);

    repairJob.setCustomer(customer);
    repairJob =  repairJobRepository.save(repairJob);
    for(RepairItem repairItem:repairJob.getRepairItem()){
        repairItemRepository.save(repairItem);
    }
    return repairJob;
}

    @Override
    public void removeRepairJob(long id) {
        repairJobRepository.deleteById(id);
    }

    @Override
    public void updateRepairJob(long id, RepairJob updateRepairJob) {
        Optional<RepairJob> optionalRepairJob = repairJobRepository.findById(id);
        if (optionalRepairJob.isPresent()) {
            repairJobRepository.save(updateRepairJob);
        } else {
            throw new RecordNotFoundException("Person does not exist");
        }
    }
}
