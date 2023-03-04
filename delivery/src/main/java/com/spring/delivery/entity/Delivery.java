package com.spring.delivery.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deliveryId;
	
	@Column(nullable = false)
	private String deliveryStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id",nullable = false)
	private Store store;
	
	@Column(nullable = false)
	private int totalPrice;
	
	@CreatedDate
	@Column(updatable = false,nullable = false)
	private Timestamp createAt;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Pay> pays = new ArrayList<Pay>();
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DeliveryMenu> deliverymenus = new ArrayList<DeliveryMenu>();
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DeliveryOption> deliverymenuoptions = new ArrayList<DeliveryOption>();
	
}
