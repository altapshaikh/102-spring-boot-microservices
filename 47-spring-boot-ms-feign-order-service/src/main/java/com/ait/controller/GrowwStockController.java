package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ait.service.GrowwOrderClient;

@RestController
public class GrowwStockController {
	@Autowired
	GrowwOrderClient growwOrderClient;
	@GetMapping(value = "/order/{stockName}/{amount}")
	public ResponseEntity<String> placeOrder(@PathVariable("stockName")String stockName,
            @PathVariable("amount")int amount){
		ResponseEntity<String> stock = growwOrderClient.getStock(stockName, amount);
		return stock;
	}
	
	
}
