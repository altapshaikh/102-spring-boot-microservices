package com.ait.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // ignore unknown values
@JsonInclude(JsonInclude.Include.NON_NULL) // ignore null fields
public class TrainTicket {
	@JsonProperty
	private Long id;
	@JsonProperty
	private String passengerName;
	@JsonProperty
	private String trainName;
	@JsonProperty
	private String sourceStation;
	@JsonProperty
	private String destinationStation;
	@JsonProperty
	private String dateOfTravel;
	@JsonProperty
	private int numberOfSeats;
}
