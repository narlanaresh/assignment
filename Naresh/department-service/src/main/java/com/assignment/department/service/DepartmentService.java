package com.assignment.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.assignment.department.entity.Department;
import com.assignment.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDept(Department department) {
		log.info("Inside save depart of department service");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		log.info("Inside findDepartmentById of department serviceß");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
