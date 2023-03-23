package com.spring.deal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.deal.service.WishlistServiceImpl;

@RestController
@RequestMapping(produces = "application/json")
public class WishListController {
	
	@Autowired
	WishlistServiceImpl wishlistService;
	
	@PostMapping("/posts/{itemId}/wishes")
	public ResponseEntity<?> wish(HttpServletRequest request,@PathVariable Long itemId){
		
		return wishlistService.registerWishList(request, itemId);
	}
	@DeleteMapping("/posts/wishes/{wishListId}")
	public ResponseEntity<?> wishCancel(HttpServletRequest request,@PathVariable Long wishListId){
		
		return wishlistService.cancelWishList(request, wishListId);
	}
}
