package com.spring.delivery.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Pay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payId;
	@Column(nullable = false)
	private String payType;
	@Column(nullable = false)
	private int price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery_id",nullable = false)
	private Delivery delivery;
	
	@Column(nullable = false)
	private String status;
	
	@CreatedDate
	@Column(updatable = false,nullable = false)
	private Timestamp createdAt;
}
