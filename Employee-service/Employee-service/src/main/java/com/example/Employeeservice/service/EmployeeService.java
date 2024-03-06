package com.example.Employeeservice.service;

import com.example.Employeeservice.dto.APIResponseDto;
import com.example.Employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	APIResponseDto getEmployeeById(Long employeeId);
	

}
