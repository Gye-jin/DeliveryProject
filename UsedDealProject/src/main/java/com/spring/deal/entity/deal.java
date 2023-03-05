package com.spring.deal.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

public class deal {
	
	@Id
	@Column(name = "deal_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dealId;
	
	@CreatedDate
	@Column(updatable = false,nullable = false,name = "deal_at")
	private Timestamp dealAt;
	
	@Column(name = "buy_user_score")
	private double buyUserScore;
	
	@Column(name = "sell_user_score")
	private double sellUserScore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User buyuser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User sellUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	



}
