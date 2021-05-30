package com.assignment.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.assignment.user.entity.Department;
import com.assignment.user.entity.User;
import com.assignment.user.repository.UserRepository;
import com.assignment.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		log.info("Inside the saveuser of user service");
		return userRepository.save(user);
	}



	public ResponseTemplateVO getUserWithDepartments(Long userId) {
		log.info("Inside the getUserWithDepartments of user service");
		ResponseTemplateVO vo=new ResponseTemplateVO();
		
		User user=userRepository.findByUserId(userId);
		Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getUserId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
