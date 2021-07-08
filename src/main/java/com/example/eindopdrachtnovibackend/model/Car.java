package com.example.eindopdrachtnovibackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table (name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private long id;
    private String licensePlate;
    private String dayOfCarCheck;
    private String dayOfRepairJob;

    @OneToOne(mappedBy = "car")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "car")
    private List<RepairJob> repairJobs;

    public Car(){

    }

    public Car(String licensePlate, String dayOfCarCheck, String dayOfRepairJob, Customer customer, List<RepairJob> repairJobs) {
        this.licensePlate = licensePlate;
        this.dayOfCarCheck = dayOfCarCheck;
        this.dayOfRepairJob = dayOfRepairJob;
        this.customer = customer;
        this.repairJobs = repairJobs;
    }

    public List<RepairJob> getRepairjobs() {
        return repairJobs;
    }

    public void setRepairjobs(List<RepairJob> repairjobs) {
        this.repairJobs = repairjobs;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getDayOfRepairJob() {
        return dayOfRepairJob;
    }

    public void setDayOfRepairJob(String dayOfRepairJob) {
        this.dayOfRepairJob = dayOfRepairJob;
    }
}




