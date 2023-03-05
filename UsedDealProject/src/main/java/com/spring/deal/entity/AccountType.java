package com.spring.deal.entity;

import lombok.Getter;

@Getter
public enum AccountType {
	고객("user"), 관리자("admin");

	private String AccountType;

	AccountType(String AccountType) {
		this.AccountType = AccountType;
	}
}
