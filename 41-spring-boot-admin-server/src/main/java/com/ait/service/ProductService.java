package com.ait.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.ait.bean.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class ProductService {

	//serialization   java ------>json
	public String getProduct() throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		//objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		Product product=new Product(101, "watch",
				                                      "zzyyaaaaa", new Date(),
				                                         Arrays.asList("abc","xyz"),
				                                         999d); 
		
		//convert java object to json
		String json = objectMapper.writeValueAsString(product);
		return json;
	}
	//de-serialization  json ---->javaobject
	public Product createProduct(Product product) throws JsonMappingException, JsonProcessingException {
		String json="   {\r\n"
				+ "        \"manufactureDate\": \"2025-01-31\",\r\n"
				+ "        \"quantity\":101,\r\n"
				+ "        \"price\": 999.0,\r\n"
				+ "        \"id\": 101,\r\n"
				+ "        \"name\": \"watch\",\r\n"
				+ "        \"coupens\": [\r\n"
				+ "            \"abc\",\r\n"
				+ "            \"xyz\"\r\n"
				+ "        ]\r\n"
				+ "    }\r\n"
				+ ""
				;
		ObjectMapper objectMapper=new ObjectMapper();
	//	objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		Product product1 = objectMapper.readValue(json, Product.class);
		System.out.println(product1);
		return product1;
	}  
}
