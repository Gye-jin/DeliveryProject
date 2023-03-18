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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.deal.dto.WriteCommentDTO;

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
public class Comment {
	
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	
	@Column(name = "comment_content")
	private String commentContent;
	
	@CreatedDate
	@Column(updatable = false,nullable = false,name = "created_at")
	private Timestamp createdAt;
	
	@LastModifiedDate
	@Column(nullable = false, name = "updated_at")
	private Timestamp updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	@JsonIgnore
	private Item item;
	
	public static Comment writeComment(WriteCommentDTO writeCommentDTO) {
		Comment comment = Comment.builder()
				.commentContent(writeCommentDTO.getCommentContent())
				.build();
		
		return comment;
	}
	
	public void WriteUserAndItem(User user, Item item) {
		this.user = user;
		this.item = item;
	}
	
	public void UpdateComment(String commentContent) {
		this.commentContent = commentContent;
	}

	
}
