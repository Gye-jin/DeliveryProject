package com.spring.deal.dto;

import java.sql.Timestamp;

import com.spring.deal.entity.AccountType;

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
	

	private String name;
	
	private String phoneNumber;
	
	private String address;
	
	private AccountType accountType;
	
	private Timestamp createdAt;

	private Timestamp updatedAt;

	private double userScore;
	
	private int suspend;
	
	private boolean quit;
	
}
