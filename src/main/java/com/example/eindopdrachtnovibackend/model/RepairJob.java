package com.example.eindopdrachtnovibackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class RepairJob {

    @Id
    @GeneratedValue
    private long id;

    private String examination;
    private String customerAgrees;
    private String actions;

    @ManyToOne
    private Car car;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
