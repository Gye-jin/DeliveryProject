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
import com.spring.deal.entity.Item;
import com.spring.deal.entity.User;
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
}
