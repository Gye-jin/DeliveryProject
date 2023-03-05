package com.spring.delivery.entity;

import lombok.Getter;

@Getter
public enum userEnum {
	고객("user"), 사업자("store");

	private String userEnum;

	userEnum(String userEnum) {
		this.userEnum = userEnum;
	}
}
