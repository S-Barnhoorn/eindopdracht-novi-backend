package com.example.eindopdrachtnovibackend.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Customer customer;

    public Car(){

    }

    public Car(String licensePlate, String dayOfCarCheck, String dayOfRepairJob, List<RepairJob> repairJobs) {
        this.licensePlate = licensePlate;
        this.dayOfCarCheck = dayOfCarCheck;
        this.dayOfRepairJob = dayOfRepairJob;
    }


        public long getId () {
            return id;
        }

        public void setId ( long id){
            this.id = id;
        }

        public Customer getCustomer () {
            return customer;
        }

        public void setCustomer (Customer customer){
            this.customer = customer;
        }

        public String getLicensePlate () {
            return licensePlate;
        }

        public void setLicensePlate (String licensePlate){
            this.licensePlate = licensePlate;
        }

        public String getDayOfCarCheck () {
            return dayOfCarCheck;
        }

        public void setDayOfCarCheck (String dayOfCarCheck){
            this.dayOfCarCheck = dayOfCarCheck;
        }

        public String getDayOfRepairJob () {
            return dayOfRepairJob;
        }

        public void setDayOfRepairJob (String dayOfRepairJob){
            this.dayOfRepairJob = dayOfRepairJob;
        }
    }




