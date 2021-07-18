package com.example.eindopdrachtnovibackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class RepairItem {
    @Id
    @GeneratedValue
    private long id;
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
    @ManyToOne
    @JsonBackReference
    private RepairJob repairJob;
    public RepairItem(){
    }
    public RepairItem(String inspection, Integer inspectionPrice, String exhaustPipe, Integer exhaustPipePrice, Integer exhaustPipeQuantity, String engine, Integer enginePrice, Integer engineQuantity, String brakePads, Integer brakePadsPrice, Integer brakePadsQuantity, String brakeDiscs, Integer brakeDiscsPrice, Integer getBrakeDiscsQuantity, String repairBrakeDiscs, String repairBrakePads, String repairEngine, String repairExhaustPipe) {
        this.inspection = inspection;
        this.inspectionPrice = inspectionPrice;
        this.exhaustPipe = exhaustPipe;
        this.exhaustPipePrice = exhaustPipePrice;
        this.exhaustPipeQuantity = exhaustPipeQuantity;
        this.repairExhaustPipe = repairExhaustPipe;
        this.engine = engine;
        this.enginePrice = enginePrice;
        this.engineQuantity = engineQuantity;
        this.repairEngine = repairEngine;
        this.brakePads = brakePads;
        this.brakePadsPrice = brakePadsPrice;
        this.brakePadsQuantity = brakePadsQuantity;
        this.repairBrakePads = repairBrakePads;
        this.brakeDiscs = brakeDiscs;
        this.brakeDiscsPrice = brakeDiscsPrice;
        this.brakeDiscsQuantity = getBrakeDiscsQuantity;
        this.repairBrakeDiscs = repairBrakeDiscs;

    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public RepairJob getRepairJob() {
        return repairJob;
    }
    public void setRepairJob(RepairJob repairJob) {
        this.repairJob = repairJob;
    }
    public String getInspection() {
        return inspection;
    }
    public void setInspection(String inspection) {
        this.inspection = inspection;
    }
    public Integer getInspectionPrice() {
        return inspectionPrice;
    }
    public void setInspectionPrice(Integer inspectionPrice) {
        this.inspectionPrice = inspectionPrice;
    }
    public String getExhaustPipe() {
        return exhaustPipe;
    }
    public void setExhaustPipe(String exhaustPipe) {
        this.exhaustPipe = exhaustPipe;
    }
    public Integer getExhaustPipePrice() {
        return exhaustPipePrice;
    }
    public void setExhaustPipePrice(Integer exhaustPipePrice) {
        this.exhaustPipePrice = exhaustPipePrice;
    }
    public Integer getExhaustPipeQuantity() {
        return exhaustPipeQuantity;
    }
    public void setExhaustPipeQuantity(Integer exhaustPipeQuantity) {
        this.exhaustPipeQuantity = exhaustPipeQuantity;
    }
    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }
    public Integer getEnginePrice() {
        return enginePrice;
    }
    public void setEnginePrice(Integer enginePrice) {
        this.enginePrice = enginePrice;
    }
    public Integer getEngineQuantity() {
        return engineQuantity;
    }
    public void setEngineQuantity(Integer engineQuantity) {
        this.engineQuantity = engineQuantity;
    }
    public String getBrakePads() {
        return brakePads;
    }
    public void setBrakePads(String brakePads) {
        this.brakePads = brakePads;
    }
    public Integer getBrakePadsPrice() {
        return brakePadsPrice;
    }
    public void setBrakePadsPrice(Integer brakePadsPrice) {
        this.brakePadsPrice = brakePadsPrice;
    }
    public Integer getBrakePadsQuantity() {
        return brakePadsQuantity;
    }
    public void setBrakePadsQuantity(Integer brakePadsQuantity) {
        this.brakePadsQuantity = brakePadsQuantity;
    }
    public String getBrakeDiscs() {
        return brakeDiscs;
    }
    public void setBrakeDiscs(String brakeDiscs) {
        this.brakeDiscs = brakeDiscs;
    }
    public Integer getBrakeDiscsPrice() {
        return brakeDiscsPrice;
    }
    public void setBrakeDiscsPrice(Integer brakeDiscsPrice) {
        this.brakeDiscsPrice = brakeDiscsPrice;
    }

    public String getRepairExhaustPipe() {
        return repairExhaustPipe;
    }
    public void setRepairExhaustPipe(String repairExhaustPipe) {
        this.repairExhaustPipe = repairExhaustPipe;
    }
    public String getRepairEngine() {
        return repairEngine;
    }
    public void setRepairEngine(String repairEngine) {
        this.repairEngine = repairEngine;
    }
    public String getRepairBrakePads() {
        return repairBrakePads;
    }
    public void setRepairBrakePads(String repairBrakePads) {
        this.repairBrakePads = repairBrakePads;
    }
    public Integer getBrakeDiscsQuantity() {
        return brakeDiscsQuantity;
    }
    public void setBrakeDiscsQuantity(Integer brakeDiscsQuantity) {
        this.brakeDiscsQuantity = brakeDiscsQuantity;
    }
    public String getRepairBrakeDiscs() {
        return repairBrakeDiscs;
    }
    public void setRepairBrakeDiscs(String repairBrakeDiscs) {
        this.repairBrakeDiscs = repairBrakeDiscs;
    }
}