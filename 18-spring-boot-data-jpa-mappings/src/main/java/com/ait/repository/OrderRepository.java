package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.model.ProductOrderEntity;

public interface OrderRepository 
                          extends JpaRepository<ProductOrderEntity, Integer> {

}
