package com.ait.service;

import org.springframework.stereotype.Service;

@Service("icicibankservice")
public class ICICIBankService implements Rbi {
	
	@Override
	public String homeLoanIntrest() {
		return "ICICI Current home loan intrest rate is 9.75%....!!!";
	}
	
}
