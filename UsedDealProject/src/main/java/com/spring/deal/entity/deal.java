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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.deal.dto.DealDTO;

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
public class Deal {
	
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
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	

	public static Deal dealSuccess(Item item, User user, DealDTO DealDTO) {
		Deal deal = Deal.builder()
				.user(user)
				.buyUserScore(DealDTO.getBuyUserScore())
				.sellUserScore(DealDTO.getSellUserScore())
				.item(item)
				.build();
	
		return deal;
	}

}
