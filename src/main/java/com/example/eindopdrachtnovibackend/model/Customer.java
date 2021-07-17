package com.example.eindopdrachtnovibackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String residence;
    private String emailAdress;
    private String phoneNumber;
    private int age;

    @OneToOne(mappedBy = "customer")
    @JsonBackReference
    private RepairJob repairJob;

    public Customer(){

    }

    public Customer(String firstName, String lastName, String residence, String emailAdress, String phoneNumber, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.residence = residence;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }


    public RepairJob getRepairJob() {
        return repairJob;
    }

    public void setRepairJob(RepairJob repairJob) {
        this.repairJob = repairJob;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
