package com.ait.service;

import org.springframework.stereotype.Service;

@Service("sbibankservice")
public class SbiBankService implements Rbi {

	@Override
	public String homeLoanIntrest() {
		return "SBI Current home loan intrest rate is 6.75%....!!!";
	}

}
