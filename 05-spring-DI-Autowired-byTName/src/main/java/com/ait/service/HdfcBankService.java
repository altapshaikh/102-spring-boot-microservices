package com.ait.service;

import org.springframework.stereotype.Service;

@Service("hdfcbankservice")
public class HdfcBankService implements Rbi {

	@Override
	public String homeLoanIntrest() {
		return "HdfcBank Current home loan intrest rate is 8.75%....!!!";
	}
}

