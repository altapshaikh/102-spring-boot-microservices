package com.ait.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "test controller" ,description = "swagger multiple controller testing ")
public class TestController {
@GetMapping(value="/data")
	public void getData() {
		
	}
}
