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
public class DealDTO {
	

	private Long dealId;
	
	private Timestamp dealAt;

	private double buyUserScore;

	private double sellUserScore;
	
	private UserDTO buyuser;
	
	private ItemDTO item;
	



}
