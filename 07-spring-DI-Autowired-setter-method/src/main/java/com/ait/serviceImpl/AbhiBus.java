package com.ait.serviceImpl;

import org.springframework.stereotype.Service;

import com.ait.service.BusBookingService;

@Service("abhibus")
public class AbhiBus implements BusBookingService {

	@Override
	public String bookTicket() {

		return "Welcome to AbhiBus, Now you can book the ticket......!!!";
	}

}
