package com.ait.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "national-stock-exchange")
public interface GrowwOrderClient {
	
	@GetMapping(value = "/order/{stockName}/{amount}")
	ResponseEntity<String>getStock(@PathVariable("stockName")String stockName,
            @PathVariable("amount")int amount);
}
