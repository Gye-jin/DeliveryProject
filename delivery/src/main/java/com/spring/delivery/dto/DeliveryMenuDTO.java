package com.spring.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DeliveryMenuDTO {
	
	private Long menuId;
	
	private Long deliveryId;
	
	private int count;

}
