package com.ait.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/flipkart")
@RestController
public class FlipkartController {

	@GetMapping(value = "/grocerry")
	public String getWelcomeMessage() {
		return "welcome to flipkart......SERVICE-1...!!!";
	}
	
}
