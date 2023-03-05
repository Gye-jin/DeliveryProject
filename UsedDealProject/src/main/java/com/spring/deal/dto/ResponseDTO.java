package com.spring.deal.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseDTO<T> {
    private final String msg;
    private final T data;
}
