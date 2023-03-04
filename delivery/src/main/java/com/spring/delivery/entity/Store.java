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
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User owner;
	
	@Column(nullable = false)
	private boolean openStatus;
	
	@Column(nullable = false)
	private String introduction;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@CreatedDate
	@Column(updatable = false,nullable = false)
	private Timestamp createdAt;
	
	@LastModifiedDate
	@Column(nullable = false)
	private Timestamp updatedAt;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Delivery> deliverys = new ArrayList<>();
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Menu> menus = new ArrayList<>();
	
}
