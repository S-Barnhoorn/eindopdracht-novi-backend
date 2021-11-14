package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.controller.dto.CarDto;
import com.example.eindopdrachtnovibackend.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    Car getCar(long id);
    Car addCar(CarDto carDto);
    void removeCar(long id);
    void updateCar(long id, Car car);
}
