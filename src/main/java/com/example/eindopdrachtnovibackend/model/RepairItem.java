package com.example.eindopdrachtnovibackend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    private String engine;
    private Integer enginePrice;
    private Integer engineQuantity;
    private String brakePads;
    private Integer brakePadsPrice;
    private Integer brakePadsQuantity;
    private String brakeDiscs;
    private Integer brakeDiscsPrice;
    private Integer brakeDiscsQuantity;

    @OneToOne
    private RepairJob repairJob;

    public RepairItem(){

    }

    public RepairItem(String inspection, Integer inspectionPrice, String exhaustPipe, Integer exhaustPipePrice, Integer exhaustPipeQuantity, String engine, Integer enginePrice, Integer engineQuantity, String brakePads, Integer brakePadsPrice, Integer brakePadsQuantity, String brakeDiscs, Integer brakeDiscsPrice, Integer getBrakeDiscsQuantity) {
        this.inspection = inspection;
        this.inspectionPrice = inspectionPrice;
        this.exhaustPipe = exhaustPipe;
        this.exhaustPipePrice = exhaustPipePrice;
        this.exhaustPipeQuantity = exhaustPipeQuantity;
        this.engine = engine;
        this.enginePrice = enginePrice;
        this.engineQuantity = engineQuantity;
        this.brakePads = brakePads;
        this.brakePadsPrice = brakePadsPrice;
        this.brakePadsQuantity = brakePadsQuantity;
        this.brakeDiscs = brakeDiscs;
        this.brakeDiscsPrice = brakeDiscsPrice;
        this.brakeDiscsQuantity = getBrakeDiscsQuantity;
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

    public Integer getbrakeDiscsQuantity() {
        return brakeDiscsQuantity;
    }

    public void setbrakeDiscsQuantity(Integer brakeDiscsQuantity) {
        this.brakeDiscsQuantity = brakeDiscsQuantity;
    }
}
