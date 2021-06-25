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
}
