package com.example.eindopdrachtnovibackend.repository;

import com.example.eindopdrachtnovibackend.model.RepairJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairJobRepository extends JpaRepository<RepairJob, Long> {
}
