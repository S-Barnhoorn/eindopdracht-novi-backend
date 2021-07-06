package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCar();
    Car getCar(long id);
    Car addCar(Car car);
    void removeCar(long id);
    void updateCar(long id, Car car);
}
