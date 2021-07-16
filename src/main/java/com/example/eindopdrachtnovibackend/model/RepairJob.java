package com.example.eindopdrachtnovibackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class RepairJob {

    @Id
    @GeneratedValue
    private long id;

    private String examination;
    private String customerAgrees;



//    @ManyToOne
//    private Car car;

    @OneToOne(mappedBy = "repairJob")
    private RepairItem repairItem;

    @OneToOne
    @Cascade(CascadeType.ALL)
    @JsonManagedReference
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RepairItem getRepairItem() {
        return repairItem;
    }

    public void setRepairItem(RepairItem repairItem) {
        this.repairItem = repairItem;
    }

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }
}
