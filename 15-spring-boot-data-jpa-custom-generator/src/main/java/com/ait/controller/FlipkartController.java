package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.entity.FlipkartEntity;
import com.ait.repository.FlipkartRepository;

@Component
public class FlipkartController {

	@Autowired
	private FlipkartRepository repository;
	
	public void registerProduct() {
		
		for(int i=0; i<10; i++) {
			FlipkartEntity entity=new FlipkartEntity();
			entity.setProduct("product_"+i);
			repository.save(entity);
		}
		
	}
}
