package com.spring.deal.dto;

import com.spring.deal.entity.Wishlist;

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

	private PageDTO item;
	
	
	public static WishlistDTO EntitiyToDTO(Wishlist wishList) {
		WishlistDTO wishlistDTO = WishlistDTO.builder()
				.wishListId(wishList.getWishListId())
				.item(PageDTO.EntitiyToDTO(wishList.getItem()))
				.build();
				
		return wishlistDTO;
	}
}
