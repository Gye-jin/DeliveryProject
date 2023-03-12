package com.spring.deal.dto;

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
	
	
	public static UserDTO EntitiyToDTO(User user) {
		UserDTO userDTO = UserDTO.builder()
				.userId(user.getUserId())
				.name(user.getName())
				.accountType(user.getAccountType())
				.address(user.getAddress())
				.password(user.getPassword())
				.build();
		return userDTO;
	}
}
