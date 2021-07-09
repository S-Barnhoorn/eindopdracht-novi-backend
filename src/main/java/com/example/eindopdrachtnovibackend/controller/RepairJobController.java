package com.example.eindopdrachtnovibackend.controller;

import com.example.eindopdrachtnovibackend.model.RepairJob;
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
import org.springframework.web.bind.annotation.RestController;



    @RestController
    @RequestMapping("/api/v1/")
    public class RepairJobController{

        @Autowired
        private RepairJobService repairJobService;

        @GetMapping("/repair-jobs")
        public ResponseEntity<Object> getRepairJob() {
            return ResponseEntity.ok(repairJobService.getRepairJob());
        }

        @PostMapping("/repair-jobs")
        public ResponseEntity<Object> addRepairJob (@RequestBody RepairJob repairJob) {
            repairJobService.addRepairJob(repairJob);
            return ResponseEntity.ok("Added");
        }

        @GetMapping("/repair-jobs/{id}")
        public ResponseEntity<Object> getRepairJob(@PathVariable("id") long id) {
            RepairJob repairJob = repairJobService.getRepairJob(id);
            return ResponseEntity.ok(repairJob);
        }


        @PutMapping("/repair-jobs/{id}")
        public ResponseEntity<Object> updateRepairJob(@PathVariable("id") long id, @RequestBody RepairJob updateRepairJob) {
            repairJobService.updateRepairJob(id, updateRepairJob);
            return ResponseEntity.noContent().build();
        }
        @DeleteMapping("/repair-jobs/{id}")
        public ResponseEntity<Object> removeRepairJob(@PathVariable("id") long id) {
            repairJobService.removeRepairJob(id);
            return ResponseEntity.noContent().build().ok("Deleted");
        }
}
