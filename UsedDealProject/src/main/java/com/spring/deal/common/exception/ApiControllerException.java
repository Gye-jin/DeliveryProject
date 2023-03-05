package com.spring.deal.common.exception;

import com.spring.deal.common.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiControllerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final ErrorCode errorCode;

}
