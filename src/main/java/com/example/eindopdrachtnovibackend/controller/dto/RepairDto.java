package com.example.eindopdrachtnovibackend.controller.dto;

import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.model.RepairItem;
import com.example.eindopdrachtnovibackend.model.RepairJob;

import java.util.List;
import java.util.stream.Collectors;

public class RepairDto {
    private long customerId;
    private String examination;
    private String customerAgrees;
    private String repairStatus;
    private List<RepairItemDto> repairItemList;

    public static RepairDto fromRepairStatus(RepairJob repairJob) {
        if (repairJob == null) return null;
        var dto = new RepairDto();
        dto.repairStatus = repairJob.getRepairStatus();
        dto.examination = repairJob.getExamination();
        dto.customerAgrees = repairJob.getCustomerAgrees();
        dto.customerId = repairJob.getId();
        return dto;
    }

    public static RepairDto fromRepairJob(RepairJob repairJob) {
        var dto = new RepairDto();
//        dto.id = list.getId();
//        dto.name = list.getName();
        dto.repairItemList = repairJob.getRepairItem().stream().map(RepairItemDto::fromRepairItem).collect(Collectors.toList());
        return dto;
    }

    public static RepairJob toRepairJob(RepairDto repairDto) {
        var list = new RepairJob();
//        list.setId(dto.id);
//        list.setName(dto.name);

        list.setRepairItem(repairDto.repairItemList.stream().map(itemDto -> RepairItemDto.toRepairItem(itemDto, list)).collect(Collectors.toList()));

        return list;
    }

    public List<RepairItemDto> getRepairItemList() {
        return repairItemList;
    }

    public void setRepairItemList(List<RepairItemDto> repairItemList) {
        this.repairItemList = repairItemList;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String actions) {
        this.repairStatus = actions;
    }
}
