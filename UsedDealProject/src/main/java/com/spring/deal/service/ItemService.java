package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.spring.deal.dto.ItemDTO;

public interface ItemService {
	
	public ResponseEntity<?> registerItem(HttpServletRequest request,ItemDTO itemDTO);
	
	public ResponseEntity<?> checkItem(HttpServletRequest request,Long itemId);
}
