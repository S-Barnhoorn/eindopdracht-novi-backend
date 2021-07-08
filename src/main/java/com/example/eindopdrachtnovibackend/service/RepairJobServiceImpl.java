package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.exception.RecordNotFoundException;
import com.example.eindopdrachtnovibackend.model.RepairJob;
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
    public RepairJob addRepairJob (RepairJob repairJob){
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
