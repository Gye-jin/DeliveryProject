package com.spring.delivery.dto;

import java.sql.Timestamp;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DeliveryDTO {
	
	private Long deliveryId;
	
	private String deliveryStatus;
	
	private String userId;
	
	private Long storeId;
	
	private int totalPrice;
	
	@CreatedDate
	@Column(updatable = false)
	private Timestamp createAt;
}
