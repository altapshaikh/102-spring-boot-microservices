package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.bean.Product;
import com.ait.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping(value = "/product")
	public String getProduct() throws JsonProcessingException {
		String product = productService.getProduct();
		return product;
	}

	@PostMapping(value = "create")
	public Product saveProduct(@RequestBody Product product) throws JsonMappingException, JsonProcessingException {
		Product product2 = productService.createProduct(product);
		return product2;
	}
}
