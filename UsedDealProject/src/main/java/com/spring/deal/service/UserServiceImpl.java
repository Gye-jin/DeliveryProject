package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.deal.common.ErrorCode;
import com.spring.deal.common.exception.ApiControllerException;
import com.spring.deal.dto.ResponseDTO;
import com.spring.deal.dto.UserDTO;
import com.spring.deal.entity.Deal;
import com.spring.deal.entity.User;
import com.spring.deal.repository.DealRepository;
import com.spring.deal.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	DealRepository dealRepository;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public ResponseEntity<?> joinUser(UserDTO userDTO){
		if(userRepository.existsByUserId(userDTO.getUserId())) {
			throw new ApiControllerException(ErrorCode.CONFILICT);
		}
		
		User user = User.DTOtoEntity(userDTO);
		user.passwordEncoding(encoder.encode(user.getPassword()));
		userRepository.save(user);
		
		return new ResponseEntity<>(new ResponseDTO<>("회원가입성공",user.getUserId()),HttpStatus.CREATED);
	}
	@Override
	@Transactional
	public ResponseEntity<?> suspendUser(HttpServletRequest request, Long dealId){
		
		User user = userRepository.findById(request.getAttribute("userId").toString()).orElseThrow(() -> new ApiControllerException(ErrorCode.BAD_REQUEST));
		Deal deal = dealRepository.findById(dealId).orElseThrow(()-> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));

		if(user.equals(deal.getUser())) {
			User suspendUser = deal.getItem().getUser(); 
			suspendUser.suspend();
			if(suspendUser.getSuspend()>=3) {
				suspendUser.AccountLocked();
			}
		}
		
		return new ResponseEntity<>(new ResponseDTO<>("신고완료",dealId),HttpStatus.CREATED);
	}
	
	@Override
	@Transactional
	public ResponseEntity<?> deleteUser(HttpServletRequest request){
		User user = userRepository.findById(request.getAttribute("userId").toString()).orElseThrow(() -> new ApiControllerException(ErrorCode.BAD_REQUEST));
		user.quit();
		
		return new ResponseEntity<>(new ResponseDTO<>("회원탈퇴성공",user.getUserId()),HttpStatus.OK);
	}
}
