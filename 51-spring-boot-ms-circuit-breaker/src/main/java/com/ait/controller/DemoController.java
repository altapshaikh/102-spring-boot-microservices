package com.ait.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DemoController {

	@GetMapping(value = "/currancy")
	@CircuitBreaker(name = "product_service", fallbackMethod = "productFallBackMethod")
	public String getProductDeatils() {
	    RestTemplate template = new RestTemplate();
	    
	    // Force a failure for testing purposes
	    if (true) {
	        throw new RuntimeException("Simulated failure");
	    }

	    ResponseEntity<String> response = template.getForEntity(
	            "http://localhost:5656/currancy_exchange/from/INR/to/DOLLER/quantity/20000", String.class);
	    return response.getBody();
	}

	
	public String productFallBackMethod(Throwable t) {
	    return "Currency service is down at the moment, try after some time...!!";
	}

	
	
	
	
	
	
}
