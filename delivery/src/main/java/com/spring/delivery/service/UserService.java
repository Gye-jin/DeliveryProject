package com.spring.delivery.service;

import org.springframework.http.ResponseEntity;

import com.spring.delivery.dto.UserDTO;

public interface UserService {
	public ResponseEntity<?> joinUser(UserDTO userDTO);

}
