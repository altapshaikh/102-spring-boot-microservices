package com.ait.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.serviceImpl.DTDCServiceImpl;

@Component
public class Flipkart {
	
	@Autowired
	private DTDCServiceImpl dtdcServiceImpl;

//	@Autowired
//	public Flipkart(DTDCServiceImpl dtdcServiceImpl) {
//		System.out.println("Flipkart: con with DTDC impl...................! )");
//		this.dtdcServiceImpl = dtdcServiceImpl;
//	}

	// @Autowired
	// public void setDtdcServiceImpl(DTDCServiceImpl dtdcServiceImpl) {
	// this.dtdcServiceImpl = dtdcServiceImpl;
	// }

	public void sendCourier(String orderId, String address) {
		System.out.println("courier is started for your orderID:" + orderId);
		dtdcServiceImpl.deliver(orderId, address);
	}

}
