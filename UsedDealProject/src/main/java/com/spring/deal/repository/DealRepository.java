package com.spring.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.deal.entity.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long>{

}
