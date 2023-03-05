package com.spring.delivery.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.spring.delivery.entity.userEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
	
	private String userId;
	
	private String password;
	
	private String email;
	
	private String name;
	
	private String phone;
	
	private String address;
	
	private userEnum level;
	
	@CreatedDate
	@Column(updatable = false)
	private Timestamp createdAt;
	
	@LastModifiedDate
	private Timestamp updatedAt;
}
