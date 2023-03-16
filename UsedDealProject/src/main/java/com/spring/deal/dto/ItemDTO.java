package com.spring.deal.dto;

import java.sql.Timestamp;

import com.spring.deal.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemDTO {
		
	private String itemName;
	
	private String itemDescription;
	
	private int itemPrice;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private boolean success;
	
	private UserDTO user;
	
	public static ItemDTO EntitiyToDTO(Item item) {
		ItemDTO itemDTO = ItemDTO.builder()
				.itemName(item.getItemName())
				.itemDescription(item.getItemDescription())
				.createdAt(item.getCreatedAt())
				.updatedAt(item.getUpdatedAt())
				.success(item.isSuccess())
				.user(UserDTO.EntitiyToDTO(item.getUser()))
				.build();
		return itemDTO;
	}
}
