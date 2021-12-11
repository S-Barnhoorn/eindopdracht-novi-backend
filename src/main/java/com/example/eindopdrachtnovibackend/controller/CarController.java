package com.example.eindopdrachtnovibackend.controller;

import com.example.eindopdrachtnovibackend.controller.dto.CarDto;
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


@RestController
@RequestMapping("/api/v1/")
public class CarController {


    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<Object> getCars() {
        return ResponseEntity.ok(carService.getCars());
    }

    @PostMapping("/cars")
    public ResponseEntity<Object> addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Object> getCar(@PathVariable("id") long id) {
        Car car = carService.getCar(id);
        return ResponseEntity.ok(car);
    }

    //query to search on firstname (customers/firstname?firstname=David
    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable("id") long id, @RequestBody Car updateCar) {
        carService.updateCar(id, updateCar);
        return ResponseEntity.noContent().build().ok("Updated");
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> removeCar(@PathVariable("id") long id) {
        carService.removeCar(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}