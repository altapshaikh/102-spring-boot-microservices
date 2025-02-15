package com.ait.serviceImpl;

import org.springframework.stereotype.Service;

import com.ait.service.BusBookingService;
@Service("redbus")
public class RedBus implements BusBookingService {

	@Override
	public String bookTicket() {
return "Welcome to RedBus, Now you can book the ticket......!!!";
	}

}
