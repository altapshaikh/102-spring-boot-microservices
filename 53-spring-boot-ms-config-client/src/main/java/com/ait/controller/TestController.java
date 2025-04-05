package com.ait.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
@Value("${message}")
	String msg;
 @Value("${spring.application.name}")
   String name;

	@GetMapping
	public Map<String,String> getProp() {
		Map<String, String>val=new HashMap<>();
		val.put("msg", msg);
		val.put("name", name);
		
		return val;
	}
}
