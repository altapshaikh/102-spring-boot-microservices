package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.service.BankService;

@Component
public class FlatController {
	@Autowired
	BankService bankService;   //byType
	//private String name;
	
	public String checkIntrestRateForHomeLoan() {
		String intrestRate = bankService.getIntrestRate();
		return intrestRate;
	}
	
	
}
