package com.ait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ashokit")
public class AshokItController {
	@GetMapping(value = "/welcome")
	public String welcomeToAshokIt() {	
		return "ashokit";
	}
}
