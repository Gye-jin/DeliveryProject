package com.spring.deal.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.deal.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@Table(name = "user")
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
		
	@Column(name = "phone_number",nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false, name = "account_type")
	private AccountType accountType;
	
	@CreatedDate
	@Column(updatable = false,nullable = false,name = "created_at")
	private Timestamp createdAt;
	
	@LastModifiedDate
	@Column(nullable = false, name = "updated_at")
	private Timestamp updatedAt;
	
	@Column(name = "user_score", nullable = false)
	private double userScore;
	
	private int suspend;
	
	private boolean quit;
	
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 Collection<GrantedAuthority> authorities = new ArrayList<>();
		 authorities.add(() ->this.accountType.toString());
		 return authorities;  
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void passwordEncoding(String password) {
		this.password = password;
	}
	
	public static User DTOtoEntity(UserDTO userDTO) {
		User user = User.builder()
				.userId(userDTO.getUserId())
				.password(userDTO.getPassword())
				.userScore(userDTO.getUserScore())
				.accountType(userDTO.getAccountType())
				.name(userDTO.getName())
				.address(userDTO.getAddress())
				.phoneNumber(userDTO.getPhoneNumber())
				.suspend(userDTO.getSuspend())
				.createdAt(userDTO.getCreatedAt())
				.updatedAt(userDTO.getUpdatedAt())
				.quit(userDTO.isQuit())
				.build();
		return user;
	}
	
	
}
