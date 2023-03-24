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
public class PageDTO {
	
	private Long itemId;
	
	private String itemName;
	
	private String itemDescription;
	
	private int itemPrice;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private boolean success;
	
	private String userId;	
	
	public static PageDTO EntitiyToDTO(Item item) {
		PageDTO pageDTO = PageDTO.builder()
				.itemId(item.getItemId())
				.itemName(item.getItemName())
				.itemDescription(item.getItemDescription())
				.itemPrice(item.getItemPrice())
				.createdAt(item.getCreatedAt())
				.updatedAt(item.getUpdatedAt())
				.success(item.isSuccess())
				.userId(item.getUser().getUserId())
				.build();
		return pageDTO;
	}
}
