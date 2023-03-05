package com.spring.deal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.deal.dto.UserDTO;
import com.spring.deal.service.UserServiceImpl;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("join")
	public ResponseEntity<?> join(@RequestBody UserDTO userDTO){
		System.out.println(userDTO);
		return userService.joinUser(userDTO);
	}
}
