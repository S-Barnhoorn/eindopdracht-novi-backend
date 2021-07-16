package com.example.eindopdrachtnovibackend.repository;

import com.example.eindopdrachtnovibackend.model.RepairItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairItemRepository extends JpaRepository<RepairItem, Long> {
    List<RepairItem> getRepairItemById(Long id);
}
