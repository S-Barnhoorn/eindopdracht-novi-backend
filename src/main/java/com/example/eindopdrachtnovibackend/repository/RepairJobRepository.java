package com.example.eindopdrachtnovibackend.repository;

import com.example.eindopdrachtnovibackend.model.RepairJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepairJobRepository extends JpaRepository<RepairJob, Long> {

    List<RepairJob> findRepairJobsByCustomerAgrees(String customerAgrees);

    List<RepairJob> findRepairJobsByRepairStatus(String repairStatus);
}
