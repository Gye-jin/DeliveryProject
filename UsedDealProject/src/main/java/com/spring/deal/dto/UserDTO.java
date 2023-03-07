package com.spring.deal.dto;

import java.sql.Timestamp;

import com.spring.deal.entity.AccountType;
import com.spring.deal.entity.User;

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
	
	public static UserDTO EntitiyToDTO(User user) {
		UserDTO userDTO = UserDTO.builder()
				.userId(user.getUserId())
				.name(user.getName())
				.accountType(user.getAccountType())
				.address(user.getAddress())
				.password(user.getPassword())
				.createdAt(user.getCreatedAt())
				.updatedAt(user.getUpdatedAt())
				.phoneNumber(user.getPhoneNumber())
				.quit(user.isQuit())
				.userScore(user.getUserScore())
				.suspend(user.getSuspend())
				.build();
		return userDTO;
	}
}
