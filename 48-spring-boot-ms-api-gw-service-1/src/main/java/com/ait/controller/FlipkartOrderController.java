package com.ait.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.GET;

@RestController
public class FlipkartOrderController {

	@GetMapping(value = "/fashion")
	public String getFashion() {
		return "welcome to flipkart fashion service...!!!";
	}
	
}
