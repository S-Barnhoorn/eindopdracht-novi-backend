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
    private String engine;
    private Integer enginePrice;
    private Integer engineQuantity;
    private String brakePads;
    private Integer brakePadsPrice;
    private Integer brakePadsQuantity;
    private String brakeDiscs;
    private Integer brakeDiscsPrice;
    private Integer brakeDiscsQuantity;


    public static RepairItemDto fromRepairItem(RepairItem repairItem) {
        var dto = new RepairItemDto();
        //dto.engine = repairItem.getEngine();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,repairItem);

        return dto;
    }

    public static RepairItem toRepairItem(RepairItemDto dto, RepairJob repairJob) {
        var item = new RepairItem();
        //item.setEngine(dto.engine);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,item);

        // this is the important bit, Item owns the relation!!!
        item.setRepairJob(repairJob);
        return item;
    }
}