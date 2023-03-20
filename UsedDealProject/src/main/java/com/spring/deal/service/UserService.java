package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.spring.deal.dto.UserDTO;

public interface UserService {
	public ResponseEntity<?> joinUser(UserDTO userDTO);
	
	public ResponseEntity<?> suspendUser(HttpServletRequest request, Long dealId);
}
