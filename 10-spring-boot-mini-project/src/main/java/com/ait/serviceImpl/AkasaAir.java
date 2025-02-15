package com.ait.serviceImpl;

import org.springframework.stereotype.Service;

import com.ait.bean.FlightBooking;
import com.ait.service.FlightService;

@Service
public class AkasaAir implements FlightService {

	@Override
	public String bookFlightTicket(FlightBooking booking) {
		System.out.println("welcome to AkasaAir: "+booking.getName());
		System.out.println("you are travelling from:"+booking.getSource()
		                                                                             +"to: "+booking.getDestination());
		System.out.println("Journy date is: "+booking.getDate());
		System.out.println("Happy Journy....................!!!");
		return "";
	}

}
