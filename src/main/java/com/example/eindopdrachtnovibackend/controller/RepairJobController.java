package com.example.eindopdrachtnovibackend.controller;

import com.example.eindopdrachtnovibackend.controller.dto.CustomerDto;
import com.example.eindopdrachtnovibackend.controller.dto.RepairDto;
import com.example.eindopdrachtnovibackend.controller.dto.RepairItemDto;
import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.model.RepairJob;
import com.example.eindopdrachtnovibackend.service.RepairItemService;
import com.example.eindopdrachtnovibackend.service.RepairJobService;
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

import java.util.ArrayList;
import java.util.List;


@RestController
    @RequestMapping("/api/v1/")
    public class RepairJobController{

        @Autowired
        private RepairJobService repairJobService;

        @Autowired
        private RepairItemService repairItemService;

        @GetMapping("/repair-jobs")
        public ResponseEntity<Object> getRepairJob() {
            return ResponseEntity.ok(repairJobService.getRepairJob());
        }

        @PostMapping("/repair-jobs")
        public ResponseEntity<Object> addRepairJob (@RequestBody RepairDto repairDto) {
            System.out.println(repairDto);
            repairJobService.addRepairJob(repairDto);
            return ResponseEntity.ok("Added");
        }

        @GetMapping("/repair-jobs/{id}")
        public ResponseEntity<Object> getRepairJob(@PathVariable("id") long id) {
            RepairJob repairJob = repairJobService.getRepairJob(id);
            return ResponseEntity.ok(repairJob);
        }

        @GetMapping("/repair-jobs/customerAgrees")
        public List<CustomerDto> getByCustomerAgrees(@RequestParam String customerAgrees){

            var repairjobs = repairJobService.getByCustomerAgrees(customerAgrees);
            var phonenumbers = new ArrayList<CustomerDto>();
            for (int i = 0; i < repairjobs.size(); i++) {
                var dto =  CustomerDto.fromCustomer(repairjobs.get(i).getCustomer());
                phonenumbers.add(dto);
            }
            return phonenumbers;
        }


        @PutMapping("/repair-jobs/{id}")
        public ResponseEntity<Object> updateRepairJob(@PathVariable("id") long id, @RequestBody RepairJob updateRepairJob) {
            System.out.println(updateRepairJob);
            repairJobService.updateRepairJob(id, updateRepairJob);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/repair-jobs/{id}")
        public ResponseEntity<Object> removeRepairJob(@PathVariable("id") long id) {
            repairJobService.removeRepairJob(id);
            return ResponseEntity.noContent().build().ok("Deleted");
        }
}
