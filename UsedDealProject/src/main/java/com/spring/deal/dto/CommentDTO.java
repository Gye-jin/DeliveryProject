package com.spring.deal.dto;

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

	private UserDTO user;

	private ItemDTO item;
}
