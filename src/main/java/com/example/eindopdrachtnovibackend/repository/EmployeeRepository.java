package com.example.eindopdrachtnovibackend.repository;

import com.example.eindopdrachtnovibackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
