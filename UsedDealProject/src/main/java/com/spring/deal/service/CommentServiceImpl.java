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
	
	@Override
	@Transactional
	public ResponseEntity<?> deleteComment(HttpServletRequest request,Long commentId){
		String userId = request.getAttribute("userId").toString();
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		if(!comment.getUser().getUserId().equals(userId)) {
			throw new ApiControllerException(ErrorCode.UNAUTHORIZED);
		}
		commentRepository.deleteById(commentId);
		return new ResponseEntity<>(new ResponseDTO<>("댓글 삭제 성공",comment.getCommentId()),HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<?> updateComment(HttpServletRequest request,Long commentId, WriteCommentDTO writeCommetnDTO){
		String userId = request.getAttribute("userId").toString();
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ApiControllerException(ErrorCode.POSTS_NOT_FOUND));
		if(!comment.getUser().getUserId().equals(userId)) {
			throw new ApiControllerException(ErrorCode.UNAUTHORIZED);
		}
		comment.UpdateComment(writeCommetnDTO.getCommentContent());
		return new ResponseEntity<>(new ResponseDTO<>("댓글 수정 성공",comment.getCommentId()),HttpStatus.OK);
	}
}
