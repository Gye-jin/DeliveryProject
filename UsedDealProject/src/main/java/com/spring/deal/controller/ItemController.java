package com.spring.deal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.deal.dto.RegistItemDTO;
import com.spring.deal.dto.DealDTO;
import com.spring.deal.service.ItemServiceImpl;
import com.spring.deal.service.WishlistServiceImpl;

@RestController
@RequestMapping(produces = "application/json")
public class ItemController {
	
	@Autowired
	ItemServiceImpl itemService;
	
	@Autowired
	WishlistServiceImpl wishlistService;
	
	
	@PostMapping("/posts")
	public ResponseEntity<?> register(HttpServletRequest request,@RequestBody RegistItemDTO registItemDTO){

		return itemService.registerItem(request,registItemDTO);
	}
	
	@GetMapping("/posts/{itemId}")
	public ResponseEntity<?> check(HttpServletRequest request,@PathVariable Long itemId){
		return itemService.checkItem(request,itemId);
	}
	
	@PutMapping("/posts/{itemId}")
	public ResponseEntity<?> update(HttpServletRequest request,@PathVariable Long itemId, @RequestBody RegistItemDTO registItemDTO){
		
		return itemService.updateItem(request,itemId,registItemDTO);
	}
	
	@PutMapping("/posts/successes/{itemId}")
	public ResponseEntity<?> success(HttpServletRequest request,@PathVariable Long itemId, @RequestBody DealDTO dealDTO){
		return itemService.successItem(request, itemId, dealDTO);
	}
	
	@DeleteMapping("/posts/{itemId}")
	public ResponseEntity<?> delete(HttpServletRequest request,@PathVariable Long itemId){
		
		return itemService.deleteItem(request,itemId);
	}
	
	@PostMapping("/posts/{itemId}/wishes")
	public ResponseEntity<?> wish(HttpServletRequest request,@PathVariable Long itemId){
		
		return wishlistService.registerWishList(request, itemId);
	}
}
