package com.ait.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ait.service.FlightService;
import com.ait.serviceImpl.AirIndia;
import com.ait.serviceImpl.AkasaAir;
import com.ait.serviceImpl.Indigo;

@Configuration
public class FlightServiceFactory {

	@Autowired
	private AirIndia airIndia;

	@Autowired
	private AkasaAir akasaAir;

	@Autowired
	private Indigo indigo;

	public FlightService getImplementation(String flightOperator) {

		if ("airindia".equalsIgnoreCase(flightOperator)) {
			return airIndia;
		} else if ("akasaair".equalsIgnoreCase(flightOperator)) {
			return akasaAir;
		} else if ("indigo".equalsIgnoreCase(flightOperator)) {
			return indigo;
		} else {
			throw new IllegalArgumentException("no flight operator availbale....!!");
		}
	}

}
