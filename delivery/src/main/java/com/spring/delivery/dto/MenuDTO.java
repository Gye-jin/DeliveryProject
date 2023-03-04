package com.spring.delivery.dto;

import java.sql.Timestamp;

import javax.persistence.Column;

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
public class MenuDTO {
	
	private Long menuId;
	
	private String name;
	
	private int price;
	
	private String photoName;
	
	private String photoPath;
	
	private String description;
	
	private Long menuGroupId;
	
	private Long StoreId;
	
	@CreatedDate
	@Column(updatable = false)
	private Timestamp createdAt;
	
	@LastModifiedDate
	private Timestamp updatedAt;

}
