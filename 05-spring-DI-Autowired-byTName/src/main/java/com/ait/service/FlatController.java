package com.ait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FlatController {
	
	@Autowired
	@Qualifier("sbibankservice")
	private Rbi rbi;
	
	public String checkIntrestRateForHomeLoan() {
		String intrestRate = rbi.homeLoanIntrest();
		return intrestRate;
	}

}
