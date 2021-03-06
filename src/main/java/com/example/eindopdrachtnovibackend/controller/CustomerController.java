package com.example.eindopdrachtnovibackend.controller;


import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class CustomerController  {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> addCustomer (@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getCustomers(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customer/firstname")
    public Customer getCustomer(@RequestParam String firstname) {
        return customerService.getByFirstName(firstname);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer updateCustomer) {
        customerService.updateCustomer(id, updateCustomer);
        return ResponseEntity.noContent().build().ok("Updated");
    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Object> removeCustomer(@PathVariable("id") long id) {
        customerService.removeCustomer(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }

}



