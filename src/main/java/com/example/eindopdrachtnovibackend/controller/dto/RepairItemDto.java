package com.example.eindopdrachtnovibackend.controller.dto;

import com.example.eindopdrachtnovibackend.model.RepairItem;
import com.example.eindopdrachtnovibackend.model.RepairJob;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class RepairItemDto {

    private String inspection;
    private Integer inspectionPrice;
    private String exhaustPipe;
    private Integer exhaustPipePrice;
    private Integer exhaustPipeQuantity;
    private String repairExhaustPipe;
    private String engine;
    private Integer enginePrice;
    private Integer engineQuantity;
    private String repairEngine;
    private String brakePads;
    private Integer brakePadsPrice;
    private Integer brakePadsQuantity;
    private String repairBrakePads;
    private String brakeDiscs;
    private Integer brakeDiscsPrice;
    private Integer brakeDiscsQuantity;
    private String repairBrakeDiscs;
    private String other;
    private Integer otherPrice;


    public static RepairItemDto fromRepairItem(RepairItem repairItem) {
        var dto = new RepairItemDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,repairItem);

        return dto;
    }

    public static RepairItem toRepairItem(RepairItemDto dto, RepairJob repairJob) {
        var item = new RepairItem();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,item);

        item.setRepairJob(repairJob);
        return item;
    }
}