package com.spring.deal.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemDTO {
	

	private Long itemId;
	
	private String itemName;
	
	private String itemDescription;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private Boolean success;
	
	private UserDTO user;
	
	
}
