package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.deal.common.ErrorCode;
import com.spring.deal.common.exception.ApiControllerException;
import com.spring.deal.dto.ItemDTO;
import com.spring.deal.dto.ResponseDTO;
import com.spring.deal.dto.DealDTO;
import com.spring.deal.entity.Deal;
import com.spring.deal.entity.Item;
import com.spring.deal.entity.User;
import com.spring.deal.repository.DealRepository;
import com.spring.deal.repository.ItemRepository;
import com.spring.deal.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	DealRepository dealRepository;
	
	@Transactional
	@Override
	public ResponseEntity<?> registerItem(HttpServletRequest request,ItemDTO itemDTO){
		String userId = request.getAttribute("userId").toString();
		User user = userRepository.findById(userId).orElseThrow(() -> new ApiControllerException(ErrorCode.UNAUTHORIZED));
		Item item = Item.DTOtoEntity(itemDTO);

		item.registerUser(user);

		itemRepository.save(item);
		
		return new ResponseEntity<>(new ResponseDTO<>("판매등록성공",item.getItemId()),HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<?> checkItem(HttpServletRequest request,Long itemId){
		
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		
		return new ResponseEntity<ItemDTO>(ItemDTO.EntitiyToDTO(item),HttpStatus.OK);
	}
	@Override
	@Transactional
	public ResponseEntity<?> updateItem(HttpServletRequest request,Long itemId,ItemDTO itemDTO){
		
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		if(!item.getUser().getUserId().equals(request.getAttribute("userId").toString())) {
			throw new ApiControllerException(ErrorCode.UNAUTHORIZED);
		}
		item.updateItem(itemDTO.getItemName(), itemDTO.getItemDescription(),itemDTO.getItemPrice());
		return new ResponseEntity<ItemDTO>(ItemDTO.EntitiyToDTO(item),HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<?> successItem(HttpServletRequest request,Long itemId, DealDTO dealDTO){
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		User user = userRepository.findById(request.getAttribute("userId").toString()).orElseThrow(() -> new ApiControllerException(ErrorCode.BAD_REQUEST));
		
		user.userScore(user.getUserScore(),dealDTO.getBuyUserScore());
		item.successItem(user.getUserScore(),dealDTO.getSellUserScore());
		Deal deal = Deal.dealSuccess(item, user, dealDTO);
		
		
		dealRepository.save(deal);
		
		return new ResponseEntity<>("판매 성공",HttpStatus.OK);
	}
	@Override
	@Transactional
	public ResponseEntity<?> deleteItem(HttpServletRequest request,Long itemId){
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		
		if(!item.getUser().getUserId().equals(request.getAttribute("userId").toString())) {
			throw new ApiControllerException(ErrorCode.UNAUTHORIZED);
		}
		
		itemRepository.deleteById(itemId);
		return new ResponseEntity<>("삭제 완료",HttpStatus.OK);
	}

	
}
