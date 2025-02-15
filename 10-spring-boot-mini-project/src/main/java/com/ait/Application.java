package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.bean.FlightBooking;
import com.ait.controller.FlightBookingController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
	
		FlightBookingController flight = run.getBean(FlightBookingController.class);
		
		FlightBooking booking =new FlightBooking();
		
		booking.setName("Raja");
		booking.setSource("Hyderabad");
		booking.setDestination("Mumbai");
		booking.setDate("03/12/2024");
		booking.setFlightOperator("airindia");
		
		flight.bookFlightTicket(booking);
	}

}
