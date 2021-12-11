package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.controller.dto.CarDto;
import com.example.eindopdrachtnovibackend.exception.RecordNotFoundException;
import com.example.eindopdrachtnovibackend.model.Car;
import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.repository.CarRepository;
import com.example.eindopdrachtnovibackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class CarServiceImpl implements CarService {
        private CarRepository carRepository;

        @Autowired
        public CarServiceImpl(CarRepository carRepository) {
            this.carRepository = carRepository;
        }

        @Autowired
        private CustomerRepository customerRepository;


        @Override
        public List<Car> getCars() {
            return carRepository.findAll();

        }
        @Override
        public Car getCar ( long id) {
            Optional<Car> car = carRepository.findById(id);
            if (car.isPresent()) {
                return car.get();
            } else {
                throw new RecordNotFoundException("Person does not exist");
            }
        }

        @Override
        public Car addCar (CarDto carDto){
            Car car = new Car();
            car.setLicensePlate(carDto.getLicensePlate());
            car.setDayOfCarCheck(carDto.getDayOfCarCheck());
            car.setDayOfRepairJob(carDto.getDayOfRepairJob());
            Customer customer = customerRepository.findById(carDto.getCustomerId()).orElse(null);
            car.setCustomer(customer);
            return carRepository.save(car);
        }

        @Override
        public void removeCar ( long id){
            carRepository.deleteById(id);

        }

        @Override
        public void updateCar(long id, Car updateCar) {
            Optional<Car> optionalCar = carRepository.findById(id);
            if (optionalCar.isPresent()) {
                carRepository.save(updateCar);
            } else {
                throw new RecordNotFoundException("Car does not exist");
            }
        }
}
