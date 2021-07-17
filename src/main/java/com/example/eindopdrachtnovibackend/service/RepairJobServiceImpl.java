package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.controller.dto.RepairDto;
import com.example.eindopdrachtnovibackend.exception.RecordNotFoundException;
import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.model.RepairItem;
import com.example.eindopdrachtnovibackend.model.RepairJob;
import com.example.eindopdrachtnovibackend.repository.CustomerRepository;
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

//    @Override
//    public Customer getByCustomerAgrees(String customerAgrees) {
//        Optional<Customer> optionalCustomer = repairJobRepository.findByCustomerAgrrees(customerAgrees);
//        if (optionalCustomer.isPresent()) {
//            return optionalCustomer.get();
//        } else {
//            throw new RecordNotFoundException("Person does not exist");
//        }
//    }

    @Override
    public List<RepairJob> getByCustomerAgrees(String customerAgrees) {
        List<RepairJob> optionalRepairJob = repairJobRepository.findRepairJobsByCustomerAgrees(customerAgrees);
        return optionalRepairJob;
    }

    @Override
    public RepairJob addRepairJob (RepairDto repairDto){
        RepairJob repairJob = new RepairJob();
        RepairItem repairItem = new RepairItem();
        repairDto.getRepairItemDto().getEngine();
        repairJob.setExamination(repairDto.getExamination());
        repairJob.setCustomerAgrees(repairDto.getCustomerAgrees());
        Customer customer = customerRepository.findById(repairDto.getCustomerId()).orElse(null);
        repairJob.setCustomer(customer);
        return repairJobRepository.save(repairJob);
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
