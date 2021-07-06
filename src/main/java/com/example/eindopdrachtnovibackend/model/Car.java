package com.example.eindopdrachtnovibackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private long id;
    private String licensePlate;
    private String dayOfCarCheck;
    private String customerAgrees;
    private String dayOfRepairJob;

    public Car(){

    }

    public Car(long id, String licensePlate, String dayOfCarCheck, String customerAgrees, String dayOfRepairJob) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.dayOfCarCheck = dayOfCarCheck;
        this.customerAgrees = customerAgrees;
        this.dayOfRepairJob = dayOfRepairJob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDayOfCarCheck() {
        return dayOfCarCheck;
    }

    public void setDayOfCarCheck(String dayOfCarCheck) {
        this.dayOfCarCheck = dayOfCarCheck;
    }

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public String getDayOfRepairJob() {
        return dayOfRepairJob;
    }

    public void setDayOfRepairJob(String dayOfRepairJob) {
        this.dayOfRepairJob = dayOfRepairJob;
    }
}




