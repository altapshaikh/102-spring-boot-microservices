package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.pojo.Customer;
import com.ait.service.CustomerService;

@Component
public class OrderController {

	@Autowired
	private CustomerService customerService;

	public Customer createCustomer(Customer customer) {
		Customer register = customerService.register(customer);
		return register;
	}

	public List<Customer> getAllCustomer() {
		List<Customer> allCustomer = customerService.getAllCustomer();
		return allCustomer;
	}

}
