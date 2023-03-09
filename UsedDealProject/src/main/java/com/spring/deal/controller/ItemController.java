package com.spring.deal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.deal.dto.ItemDTO;
import com.spring.deal.dto.DealDTO;
import com.spring.deal.service.ItemServiceImpl;

@RestController
@RequestMapping(produces = "application/json")
public class ItemController {
	
	@Autowired
	ItemServiceImpl itemService;
	
	
	@PostMapping("/posts")
	public ResponseEntity<?> register(HttpServletRequest request,@RequestBody ItemDTO itemDTO){

		return itemService.registerItem(request,itemDTO);
	}
	
	@GetMapping("/posts/{itemId}")
	public ResponseEntity<?> check(HttpServletRequest request,@PathVariable Long itemId){
		return itemService.checkItem(request,itemId);
	}
	
	@PutMapping("/posts/{itemId}")
	public ResponseEntity<?> update(HttpServletRequest request,@PathVariable Long itemId, @RequestBody ItemDTO itemDTO){
		
		return itemService.updateItem(request,itemId,itemDTO);
	}
	
	@PutMapping("/posts/successes/{itemId}")
	public ResponseEntity<?> success(HttpServletRequest request,@PathVariable Long itemId, @RequestBody DealDTO dealDTO){
		return itemService.successItem(request, itemId, dealDTO);
	}
}
