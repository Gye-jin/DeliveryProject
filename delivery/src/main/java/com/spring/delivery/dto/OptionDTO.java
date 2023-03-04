package com.spring.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OptionDTO {
	
	private Long optionId;
	
	private String name;
	
	private Long menuId;

}
