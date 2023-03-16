package com.spring.deal.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.deal.dto.ItemDTO;
import com.spring.deal.dto.RegistItemDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = "comments")
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
	
	@Column(name ="item_price")
	private int itemPrice;
	
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<Comment>();
	
	public static Item DTOtoEntity(ItemDTO itemDTO) {
		Item item = Item.builder()
						.itemName(itemDTO.getItemName())
						.itemPrice(itemDTO.getItemPrice())
						.itemDescription(itemDTO.getItemDescription())
						.createdAt(itemDTO.getCreatedAt())
						.updatedAt(itemDTO.getUpdatedAt())
						.success(itemDTO.isSuccess())
						.build();
		return item;
	}
	
	public static Item registItem(RegistItemDTO registItemDTO) {
		Item item = Item.builder()
				.itemName(registItemDTO.getItemName())
				.itemPrice(registItemDTO.getItemPrice())
				.itemDescription(registItemDTO.getItemDescription())
				.build();
		return item;
	}
	
	public void registerUser(User user) {
		this.user = user;
	}
	
	public void updateItem(String itemname, String itemDescription,int itemPrice) {
		this.itemName = itemname;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
	}
	public void successItem(double userScore, double score) {
		this.success = true;
		this.user.userScore(userScore,score);
	}
	
}
