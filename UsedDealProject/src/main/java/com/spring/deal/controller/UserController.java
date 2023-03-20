package com.spring.deal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.deal.dto.LoginDTO;
import com.spring.deal.dto.UserDTO;
import com.spring.deal.service.UserServiceImpl;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody UserDTO userDTO){
		return userService.joinUser(userDTO);
	}
	
	@PostMapping("/login")
	public void login(@RequestBody LoginDTO loginDTO){
	}
	
	@PutMapping("/users/{dealId}")
	public  ResponseEntity<?> report (HttpServletRequest request,@PathVariable Long dealId){
		
		return userService.suspendUser(request,dealId);
	}
	
	
}

