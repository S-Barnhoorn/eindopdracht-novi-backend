package com.example.eindopdrachtnovibackend.controller;

import com.example.eindopdrachtnovibackend.model.RepairItem;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class RepairItemController{

    @Autowired
    private RepairItemService repairItemService;

    @GetMapping("/repair-items")
    public ResponseEntity<Object> getRepairItem() {
        return ResponseEntity.ok(repairItemService.getRepairItem());
    }

    @PostMapping("/repair-items")
    public ResponseEntity<Object> addRepairItem (@RequestBody RepairItem repairItem) {
        repairItemService.addRepairItem(repairItem);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/repair-items/{id}")
    public ResponseEntity<Object> getRepairItem(@PathVariable("id") long id) {
        RepairItem repairItem = repairItemService.getRepairItem(id);
        return ResponseEntity.ok(repairItem);
    }


    @PutMapping("/repair-items/{id}")
    public ResponseEntity<Object> updateRepairItem(@PathVariable("id") long id, @RequestBody RepairItem updateRepairItem) {
        repairItemService.updateRepairItem(id, updateRepairItem);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/repair-items/{id}")
    public ResponseEntity<Object> removeRepairItem(@PathVariable("id") long id) {
        repairItemService.removeRepairItem(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}