package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.model.RepairItem;


import java.util.List;
import java.util.Optional;

public interface RepairItemService {
    List<RepairItem> getRepairItem();
    RepairItem getRepairItem(long id);
    RepairItem addRepairItem(RepairItem repairItem);
    void removeRepairItem(long id);
    void updateRepairItem(long id, RepairItem repairItem);


}
