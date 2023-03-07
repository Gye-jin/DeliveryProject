package com.spring.deal.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.deal.dto.ItemDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
public class Item {
	
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	@Column(name = "item_name",nullable = false)
	private String itemName;
	
	@Column(name = "item_description",nullable = false)
	private String itemDescription;
	
	@CreatedDate
	@Column(updatable = false,nullable = false,name = "created_at")
	private Timestamp createdAt;
	
	@LastModifiedDate
	@Column(nullable = false, name = "updated_at")
	private Timestamp updatedAt;
	
	private boolean success;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public static Item DTOtoEntity(ItemDTO itemDTO) {
		Item item = Item.builder()
						.itemId(itemDTO.getItemId())
						.itemName(itemDTO.getItemName())
						.itemDescription(itemDTO.getItemDescription())
						.createdAt(itemDTO.getCreatedAt())
						.updatedAt(itemDTO.getUpdatedAt())
						.success(itemDTO.isSuccess())
						.build();
		return item;
	}
	
	public void registerUser(User user) {
		this.user = user;
	}
	
	
}
