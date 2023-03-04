package com.spring.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DeliveryOption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deliveryMenuOptionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery_id",nullable = false)
	private Delivery delivery;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id",nullable = false)
	private Menu menu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "option_Id",nullable = false)
	private Option option;

}
