package com.example.departmentservice.service.Impl;

import org.springframework.stereotype.Service;

import com.example.departmentservice.Entity.Department;
import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		Department department=new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode());
		Department savedDepartment=departmentRepository.save(department);
		DepartmentDto savedDepartmentDto=new DepartmentDto(
				savedDepartment.getId(),
				savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode());
		
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		// TODO Auto-generated method stub
		Department department=departmentRepository.findByDepartmentCode(departmentCode);
		DepartmentDto departmentdto=new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode());
		return departmentdto;
	}
}
