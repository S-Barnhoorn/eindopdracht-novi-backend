package com.example.eindopdrachtnovibackend.controller;

import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.repository.CustomerRepository;
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

import java.util.List;

//@RestController
//@RequestMapping("/api/v1/")
//public class CustomerController {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @GetMapping("/customers")
//    public List<Customer> getAllCustomers(){
//        return customerRepository.findAll();
//    }
//
//    @PostMapping("/customers")
//    public Customer createCustomer(@RequestBody Customer customer){
//        return customerRepository.save(customer);
//    }
//}

@RestController
@RequestMapping("/api/v1/")
public class CustomerController  {
    @Autowired
    private CustomerService customerService;
    //krijgt verzoek binnen
    @GetMapping("/customer")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }
    //create employee rest API
    @PostMapping("/customer")
    public ResponseEntity<Object> addCustomer (@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Added");
    }
    //get 1 employee
    //krijgt verzoek binnen
    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getCustomers(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }
    //query to search on firstname (customers/firstname?firstname=David
    @GetMapping("/customer/firstname")
    public Customer getCustomer(@RequestParam String firstname) {
        return customerService.getByFirstName(firstname);
    }
    @PutMapping("/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer updateCustomer) {
        customerService.updateCustomer(id, updateCustomer);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Object> removeCustomer(@PathVariable("id") long id) {
        customerService.removeCustomer(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }

//    @GetMapping("/customer/phonenumber")
//    public Customer getCustomer(@RequestParam Integer phonenumber){
//        return customerService.getByPhoneNumber(phonenumber);
//    }

}



