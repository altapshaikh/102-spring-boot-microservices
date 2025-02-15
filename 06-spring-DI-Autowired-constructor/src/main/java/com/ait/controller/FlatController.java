package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ait.service.Rbi;

@Component
public class FlatController {
	
	private Rbi rbi;

	@Autowired
	public FlatController(@Qualifier(value = "HDFCService") Rbi rbi) {
		this.rbi = rbi;
	}

	public String getIntrestRateForFlat() {
		return rbi.intrestHomeLoanRate();
	}

}
