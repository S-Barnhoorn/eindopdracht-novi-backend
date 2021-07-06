package com.example.eindopdrachtnovibackend.repository;

import com.example.eindopdrachtnovibackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByFirstName(String firstname);
    Optional<Customer> findCustomerByPhoneNumber(Integer phoneNumber);

}
