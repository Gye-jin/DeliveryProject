package com.spring.deal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.deal.dto.RegistItemDTO;
import com.spring.deal.dto.DealDTO;
import com.spring.deal.service.ItemServiceImpl;

@RestController
@RequestMapping(produces = "application/json")
public class ItemController {
	
	@Autowired
	ItemServiceImpl itemService;
		
	@PostMapping("/items")
	public ResponseEntity<?> register(HttpServletRequest request,@RequestBody RegistItemDTO registItemDTO){

		return itemService.registerItem(request,registItemDTO);
	}
	
	@GetMapping("/items/{itemId}")
	public ResponseEntity<?> check(HttpServletRequest request,@PathVariable Long itemId){
		return itemService.checkItem(request,itemId);
	}
	
	@PatchMapping("/items/{itemId}")
	public ResponseEntity<?> update(HttpServletRequest request,@PathVariable Long itemId, @RequestBody RegistItemDTO registItemDTO){
		
		return itemService.updateItem(request,itemId,registItemDTO);
	}
	
	@PutMapping("/items/successes/{itemId}")
	public ResponseEntity<?> success(HttpServletRequest request,@PathVariable Long itemId, @RequestBody DealDTO dealDTO){
		return itemService.successItem(request, itemId, dealDTO);
	}
	
	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<?> delete(HttpServletRequest request,@PathVariable Long itemId){
		
		return itemService.deleteItem(request,itemId);
	}
	

	
}
