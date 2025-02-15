package com.ait.serviceImpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ait.service.Rbi;
@Service
@Qualifier(value = "ICICIBankService")
@Primary
public class ICICIBankService implements Rbi {

	@Override
	public String intrestHomeLoanRate() {
		return "welcome to ICICI home loan and  intrest rate is 9.75%......!!!";
	}

}
