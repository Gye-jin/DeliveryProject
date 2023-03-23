package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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
		if(!wishlistRepository.existsByItemAndUser(item, user)) {
			Wishlist wishlist = Wishlist.registerUserAndItem(user, item);
			wishlistRepository.save(wishlist);
			
			return new ResponseEntity<>(new ResponseDTO<>("위시리스트 등록완료",wishlist.getWishListId()),HttpStatus.CREATED);
		}else
			return new ResponseEntity<>(new ResponseDTO<>("위시리스트에 있는 아이템입니다.",itemId),HttpStatus.BAD_REQUEST);
		
	}
	@Override
	@Transactional
	public ResponseEntity<?> cancelWishList(HttpServletRequest request,Long wishListId){
		User user = userRepository.findById(request.getAttribute("userId").toString()).orElseThrow(() -> new ApiControllerException(ErrorCode.BAD_REQUEST));
		if(!wishlistRepository.existsByUserAndWishListId(user, wishListId)) {
			throw new ApiControllerException(ErrorCode.BAD_REQUEST);
		}
		wishlistRepository.deleteById(wishListId);
		
		return new ResponseEntity<>(new ResponseDTO<>("위시리스트 삭제완료",wishListId),HttpStatus.OK);
	}
	

}
