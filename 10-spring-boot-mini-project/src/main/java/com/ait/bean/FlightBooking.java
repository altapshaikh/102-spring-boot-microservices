package com.ait.bean;

public class FlightBooking {
	
	private String name;
	private String source;
	private String destination;
	private String flightOperator;
	private String Date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlightOperator() {
		return flightOperator;
	}
	public void setFlightOperator(String flightOperator) {
		this.flightOperator = flightOperator;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "FlightBooking [name=" + name + ", source=" + source + ", destination=" + destination
				+ ", flightOperator=" + flightOperator + ", Date=" + Date + "]";
	}
	
}
