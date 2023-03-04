package com.spring.delivery.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PayDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payId;
	
	private String payType;
	
	private int price;
	
	private Long deliveryId;
	
	private String status;
	
	@CreatedDate
	@Column(updatable = false)
	private Timestamp createdAt;
}
