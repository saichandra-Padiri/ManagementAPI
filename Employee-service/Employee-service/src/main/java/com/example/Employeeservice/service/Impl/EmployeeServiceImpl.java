package com.example.Employeeservice.service.Impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Employeeservice.Entity.Employee;
import com.example.Employeeservice.dto.APIResponseDto;
import com.example.Employeeservice.dto.DepartmentDto;
import com.example.Employeeservice.dto.EmployeeDto;
import com.example.Employeeservice.repository.EmployeeRepository;
import com.example.Employeeservice.service.APIClient;
import com.example.Employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	

	private EmployeeRepository employeeRepository;
	//private RestTemplate restTemplate;
	//private WebClient webClient;
	private APIClient apiClient;
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode());
		Employee savedEmployee=employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto=new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode());
		
		
		return savedEmployeeDto;
	}
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
//		ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(),DepartmentDto.class);
//		DepartmentDto departmentDto=responseEntity.getBody();
		//DepartmentDto departmentDto=webClient.get().uri("http://localhost:8080/api/department/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
		
		DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode());
		EmployeeDto employeeDto=new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode());
		APIResponseDto apiResponseDto=new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		// TODO Auto-generated method stub
		return apiResponseDto;
	}
	

}
