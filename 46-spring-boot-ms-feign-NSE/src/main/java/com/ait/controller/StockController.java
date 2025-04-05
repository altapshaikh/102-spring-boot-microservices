package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ait.service.StockOrderService;

@RestController
public class StockController {
	@Autowired
	StockOrderService stockOrderService;
	@GetMapping(value = "/order/{stockName}/{amount}")
	public ResponseEntity<String>placeOrder(@PathVariable("stockName")String stockName,
			                                         @PathVariable("amount")int amount){
		Integer stock = stockOrderService.placeOrder(stockName, amount);
		
		return  ResponseEntity.ok("order placed sucessfully for: "+stockName+""
				+ " and share quantity is: "+stock);
	}

}
