package com.spring.delivery.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StoreDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	
	private String name;
	
	private String phone;
	
	private String address;
	
	private String ownerId;
	
	private boolean openStatus;
	
	private String introduction;
	
	private Long categoryId;
	
	@CreatedDate
	@Column(updatable = false)
	private Timestamp createdAt;
	
	@LastModifiedDate
	private Timestamp updatedAt;
	
}
