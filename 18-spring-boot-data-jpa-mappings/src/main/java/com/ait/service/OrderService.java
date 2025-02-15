package com.ait.service;

import java.util.List;

import com.ait.pojo.ProductOrder;

public interface OrderService {

	public List<ProductOrder>getOrderByCustomerName(String name);
}
