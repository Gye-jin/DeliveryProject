package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.spring.deal.dto.ItemDTO;
import com.spring.deal.dto.DealDTO;

public interface ItemService {
	
	public ResponseEntity<?> registerItem(HttpServletRequest request,ItemDTO itemDTO);
	
	public ResponseEntity<?> checkItem(HttpServletRequest request,Long itemId);
	
	public ResponseEntity<?> updateItem(HttpServletRequest request,Long itemId,ItemDTO itemDTO);
	
	public ResponseEntity<?> successItem(HttpServletRequest request,Long itemId, DealDTO DealDTO);
}
