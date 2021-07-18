package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.model.Customer;

import java.util.List;

public interface CustomerService {
        List<Customer> getCustomers();
        Customer getCustomer(long id);
        Customer addCustomer(Customer customer);
        void removeCustomer(long id);
        void updateCustomer(long id, Customer customer);

        Customer getByFirstName(String firstname);
        Customer getByPhoneNumber(Integer phoneNumber);

}

