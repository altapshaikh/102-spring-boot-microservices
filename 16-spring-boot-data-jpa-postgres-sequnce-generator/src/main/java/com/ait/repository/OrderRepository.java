package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
