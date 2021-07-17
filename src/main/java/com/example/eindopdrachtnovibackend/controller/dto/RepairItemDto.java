package com.example.eindopdrachtnovibackend.controller.dto;

import lombok.Data;

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

}