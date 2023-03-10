package com.spring.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.deal.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long>{

}
