package com.spring.deal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.deal.dto.WriteCommentDTO;
import com.spring.deal.service.CommentServiceImpl;

@RestController
@RequestMapping(produces = "application/json")
public class CommentController {
	
	@Autowired
	CommentServiceImpl commentService;
	
	@PostMapping("/posts/{itemId}/comments")
	public ResponseEntity<?> writeComments(HttpServletRequest request,@PathVariable Long itemId, @RequestBody WriteCommentDTO writeCommetnDTO){
		
		return commentService.writeComment(request,itemId, writeCommetnDTO);
	}
	
	@DeleteMapping("/posts/{commentId}")
	public ResponseEntity<?> deleteComments(HttpServletRequest request,@PathVariable Long commentId){
		
		return commentService.deleteComment(request,commentId);
	}
	
	@PutMapping("/posts/{commentId}")
	public ResponseEntity<?> updateComments(HttpServletRequest request,@PathVariable Long commentId, @RequestBody WriteCommentDTO writeCommetnDTO){
		
		return commentService.updateComment(request,commentId,writeCommetnDTO);
	}
}
