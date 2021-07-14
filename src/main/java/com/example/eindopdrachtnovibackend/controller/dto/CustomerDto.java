package com.example.eindopdrachtnovibackend.controller.dto;

import com.example.eindopdrachtnovibackend.model.Customer;

public class CustomerDto {
    public Integer phoneNumber;
//    public String firstName;
//    public String lastName;
    public static CustomerDto fromCustomer(Customer customer) {
        if (customer == null) return null;
        var dto = new CustomerDto();
        dto.phoneNumber = customer.getPhoneNumber();
//        dto.firstName = customer.getFirstName();
//        dto.lastName = customer.getLastName();

        return dto;
    }
}
