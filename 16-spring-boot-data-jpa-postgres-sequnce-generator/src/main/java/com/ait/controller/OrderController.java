package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.entity.OrderEntity;
import com.ait.repository.OrderRepository;

@Component
public class OrderController {
	@Autowired
	private OrderRepository repository;

	public void createOrder() {

		for (int i = 0; i < 10; i++) {
			OrderEntity entity = new OrderEntity();
			entity.setProduct("product_" + i);
			repository.save(entity);
		}
	}
}
