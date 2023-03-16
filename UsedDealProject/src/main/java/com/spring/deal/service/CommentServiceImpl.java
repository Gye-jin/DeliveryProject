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
import com.spring.deal.dto.WriteCommentDTO;
import com.spring.deal.entity.Comment;
import com.spring.deal.entity.Item;
import com.spring.deal.entity.User;
import com.spring.deal.repository.CommentRepository;
import com.spring.deal.repository.ItemRepository;
import com.spring.deal.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	@Transactional
	public ResponseEntity<?> writeComment(HttpServletRequest request,Long itemId,WriteCommentDTO writeCommentDTO){
		String userId = request.getAttribute("userId").toString();
		User user = userRepository.findById(userId).orElseThrow(() -> new ApiControllerException(ErrorCode.UNAUTHORIZED));
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		
		Comment comment = Comment.writeComment(writeCommentDTO);
		comment.WriteUserAndItem(user, item);
		
		commentRepository.save(comment);
		return new ResponseEntity<>(new ResponseDTO<>("댓글 등록성공",comment.getCommentId()),HttpStatus.CREATED);
	}
}
