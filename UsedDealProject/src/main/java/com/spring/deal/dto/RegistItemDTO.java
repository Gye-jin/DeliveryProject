package com.spring.deal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegistItemDTO {
	
	private String itemName;
	
	private String itemDescription;
	
	private int itemPrice;
}
