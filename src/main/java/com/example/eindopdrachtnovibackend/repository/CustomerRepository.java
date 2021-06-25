package com.example.eindopdrachtnovibackend.repository;

import com.example.eindopdrachtnovibackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
