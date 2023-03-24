package com.spring.deal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.deal.entity.Item;
import com.spring.deal.entity.User;
import com.spring.deal.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
	
	public boolean existsByItemAndUser(Item item, User user);
	
	public boolean existsByUserAndWishListId(User user, Long wishListId);
	
	public List<Wishlist> findByUser(User user);

}
