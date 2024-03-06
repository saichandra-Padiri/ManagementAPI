package com.example.Employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employeeservice.dto.APIResponseDto;
import com.example.Employeeservice.dto.EmployeeDto;
import com.example.Employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
	private EmployeeService employeeService;
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto saveEmployee=employeeService.saveEmployee(employeeDto);
				
		return new ResponseEntity<>(saveEmployee,HttpStatus.CREATED);
		
	}
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId)
	{
		APIResponseDto apiResponseDto=employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
	}
	

}
