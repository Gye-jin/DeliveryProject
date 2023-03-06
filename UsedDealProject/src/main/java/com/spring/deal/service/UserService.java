package com.spring.deal.service;

import org.springframework.http.ResponseEntity;

import com.spring.deal.dto.UserDTO;

public interface UserService {
	public ResponseEntity<?> joinUser(UserDTO userDTO);
	
	public ResponseEntity<?> login(UserDTO userDTO);
}
