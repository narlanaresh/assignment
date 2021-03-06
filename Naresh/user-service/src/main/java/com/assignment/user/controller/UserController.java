package com.assignment.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.user.entity.User;
import com.assignment.user.service.UserService;
import com.assignment.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside the save`user of user controller");
		return userService.saveUser(user);
		
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseTemplateVO getUserWithDepartments(@PathVariable("id")  Long  userId) {
		log.info("Inside getUserWithDepartments of user controller");
		return userService.getUserWithDepartments(userId);
	}

}
