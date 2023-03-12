package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import com.spring.deal.dto.RegistItemDTO;
import com.spring.deal.dto.DealDTO;

public interface ItemService {
	
	public ResponseEntity<?> registerItem(HttpServletRequest request,RegistItemDTO registItemDTO);
	
	public ResponseEntity<?> checkItem(HttpServletRequest request,Long itemId);
	
	public ResponseEntity<?> updateItem(HttpServletRequest request,Long itemId,RegistItemDTO registItemDTO);
	
	public ResponseEntity<?> successItem(HttpServletRequest request,Long itemId, DealDTO DealDTO);
	
	public ResponseEntity<?> deleteItem(HttpServletRequest request,Long itemId);
}
