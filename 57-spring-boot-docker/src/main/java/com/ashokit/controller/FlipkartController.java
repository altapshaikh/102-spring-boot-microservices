package com.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class FlipkartController {

	@GetMapping(value = "/")
	public String getMsg(HttpServletRequest req) {
		String msg="welcome to flipkart docker conatiner and this conatiner is running on port:"+req.getServerPort();
		return msg;
		
	}
}
