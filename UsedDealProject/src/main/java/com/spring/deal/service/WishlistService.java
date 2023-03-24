package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface WishlistService {
	public ResponseEntity<?> registerWishList(HttpServletRequest request,Long itemId);
	
	public ResponseEntity<?> cancelWishList(HttpServletRequest request,Long wishListId);
	
	public ResponseEntity<?> getWishList(HttpServletRequest request);
}
