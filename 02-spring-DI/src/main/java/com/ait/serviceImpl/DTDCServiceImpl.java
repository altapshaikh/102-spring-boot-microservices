package com.ait.serviceImpl;

import org.springframework.stereotype.Component;

import com.ait.service.DeliveryService;

@Component
public class DTDCServiceImpl implements DeliveryService {

	public DTDCServiceImpl() {
		System.out.println("DTDCServiceImpl:0-param const is called.....");
	}
	@Override
	public void deliver(String id, String address) {
		System.out.println("delivering package " + id + " address: " + address);
	}

}
