package com.spring.deal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WishlistDTO {
	

	private Long wishListId;

	private UserDTO user;

	private ItemDTO item;
	

}
