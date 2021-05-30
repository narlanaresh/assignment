package com.assignment.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.department.entity.Department;
import com.assignment.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public @ResponseBody Department saveDept(@RequestBody Department department) {
		System.out.println(""+department.getDepartmentAddress()); 
		log.info("Inside save depart of department controller");
		return departmentService.saveDept(department);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Department findDepartmentById(@PathVariable("id")  Long  departmentId) {
		log.info("Inside findDepartmentById of department controller");
		return departmentService.findDepartmentById(departmentId);
	}

}
