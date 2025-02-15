package com.ait.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.pojo.ProductOrder;
import com.ait.repository.OrderRepository;
import com.ait.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<ProductOrder> getOrderByCustomerName(String name) {

		return null;
	}

}
