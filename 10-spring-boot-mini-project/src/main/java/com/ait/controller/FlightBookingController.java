package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.bean.FlightBooking;
import com.ait.service.FlightService;
import com.ait.utility.FlightServiceFactory;

@Component
public class FlightBookingController {

	private final FlightServiceFactory flightServiceFactory;

	@Autowired
	public FlightBookingController(FlightServiceFactory flightServiceFactory) {
		System.out.println("FlightBookingController: is initialized");
		this.flightServiceFactory = flightServiceFactory;
	}
	
	
	public void bookFlightTicket(FlightBooking booking) {
		
		FlightService flightService=
				            flightServiceFactory.getImplementation(booking.getFlightOperator());
		flightService.bookFlightTicket(booking);
		
	}

}
