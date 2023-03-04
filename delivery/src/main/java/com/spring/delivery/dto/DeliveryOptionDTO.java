package com.spring.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DeliveryOptionDTO {
		
	private Long deliveryId;
	
	private Long menuId;
	
	private Long optionId;

}
