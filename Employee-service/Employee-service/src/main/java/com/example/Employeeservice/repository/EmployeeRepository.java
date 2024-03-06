package com.example.Employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employeeservice.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
