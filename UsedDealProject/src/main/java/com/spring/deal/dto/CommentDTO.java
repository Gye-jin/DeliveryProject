package com.spring.deal.dto;

import java.sql.Timestamp;

import com.spring.deal.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentDTO {
	
	private Long commentId;
	
	private String commentContent;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;

	private UserDTO user;
	
	public static CommentDTO EntityToDTO(Comment comment) {
		CommentDTO commentDTO = CommentDTO.builder()
				.commentId(comment.getCommentId())
				.commentContent(comment.getCommentContent())
				.user(UserDTO.EntitiyToDTO(comment.getUser()))
				.createdAt(comment.getCreatedAt())
				.updatedAt(comment.getUpdatedAt())
				.build();
				
		return commentDTO;
	}
	
}
