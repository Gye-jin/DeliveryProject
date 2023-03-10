package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.deal.common.ErrorCode;
import com.spring.deal.common.exception.ApiControllerException;
import com.spring.deal.dto.ResponseDTO;
import com.spring.deal.entity.Item;
import com.spring.deal.entity.User;
import com.spring.deal.entity.Wishlist;
import com.spring.deal.repository.ItemRepository;
import com.spring.deal.repository.UserRepository;
import com.spring.deal.repository.WishlistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@Override
	public ResponseEntity<?> registerWishList(HttpServletRequest request,Long itemId){
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		User user = userRepository.findById(request.getAttribute("userId").toString()).orElseThrow(() -> new ApiControllerException(ErrorCode.BAD_REQUEST));
		
		Wishlist wishlist = Wishlist.registerUserAndItem(user, item);
		wishlistRepository.save(wishlist);
		
		return new ResponseEntity<>(new ResponseDTO<>("판매등록성공",wishlist.getWishListId()),HttpStatus.CREATED);
	}

}
