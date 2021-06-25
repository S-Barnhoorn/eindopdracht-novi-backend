package com.example.eindopdrachtnovibackend.repository;

import com.example.eindopdrachtnovibackend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
