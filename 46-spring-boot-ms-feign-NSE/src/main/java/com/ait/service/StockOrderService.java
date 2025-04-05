package com.ait.service;

import org.springframework.stereotype.Service;

@Service
public class StockOrderService {

	public Integer placeOrder(String stockName,int amount) {
		int quantity=0;
		if(stockName.equalsIgnoreCase("HDFC")) {
			return quantity=amount/1688;
		}else if(stockName.equalsIgnoreCase("Reliance")) {
			return quantity=amount/1267;
		}else {
			return quantity;
		}
	}
}
