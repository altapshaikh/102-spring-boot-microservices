package com.ait.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ait.service.BusBookingService;

@Component
public class BusBookingControlller {

	private BusBookingService busBookingService;

	@Autowired
	public void setBusBookingService(@Qualifier("redbus") BusBookingService busBookingService) {
		this.busBookingService = busBookingService;
	}

	public String bookTicket() {
		return busBookingService.bookTicket();
	}

}
