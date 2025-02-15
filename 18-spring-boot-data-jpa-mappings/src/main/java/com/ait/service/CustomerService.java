package com.ait.service;

import java.util.List;

import com.ait.pojo.Customer;

public interface CustomerService {
	public Customer register(Customer customer);
	public List<Customer>getAllCustomer();

}
