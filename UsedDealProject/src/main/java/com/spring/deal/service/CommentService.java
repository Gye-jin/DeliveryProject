package com.spring.deal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.spring.deal.dto.WriteCommentDTO;

public interface CommentService {
	public ResponseEntity<?> writeComment(HttpServletRequest request,Long itemId,WriteCommentDTO writeCommentDTO);
}
