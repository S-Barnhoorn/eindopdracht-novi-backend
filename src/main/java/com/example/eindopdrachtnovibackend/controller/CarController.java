package com.example.eindopdrachtnovibackend.controller;

import com.example.eindopdrachtnovibackend.model.Car;
import com.example.eindopdrachtnovibackend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CarController {


    @Autowired
    private CarService carService;

    //krijgt verzoek binnen
    @GetMapping("/cars")
    public ResponseEntity<Object> getCar() {
        return ResponseEntity.ok(carService.getCar());
    }

    //create employee rest API
    @PostMapping("/cars")
    public ResponseEntity<Object> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.ok("Added");
    }

    //get 1 employee
    //krijgt verzoek binnen
    @GetMapping("/cars/{id}")
    public ResponseEntity<Object> getCar(@PathVariable("id") long id) {
        Car car = carService.getCar(id);
        return ResponseEntity.ok(car);
    }

    //query to search on firstname (customers/firstname?firstname=David
    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable("id") long id, @RequestBody Car updateCar) {
        carService.updateCar(id, updateCar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> removeCar(@PathVariable("id") long id) {
        carService.removeCar(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}