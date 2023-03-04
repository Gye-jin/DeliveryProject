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
import org.springframework.data.annotation.LastModifiedDate;

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
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuId;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int price;
	
	private String photoName;
	
	private String photoPath;
	@Column(nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id",nullable = false)
	private Store store;
	
	@CreatedDate
	@Column(updatable = false,nullable = false)
	private Timestamp createdAt;
	
	@LastModifiedDate
	@Column(nullable = false)
	private Timestamp updatedAt;
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DeliveryOption> deliveryoptions = new ArrayList<DeliveryOption>();
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Option> menuoptions = new ArrayList<Option>();
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DeliveryMenu> deliverymenus = new ArrayList<DeliveryMenu>();

}
