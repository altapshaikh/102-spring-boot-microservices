package com.ait.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ExternalService {

	private static final String CIRCUIT_BREAKER_NAME="movieServiceCircuitBreaker";
	
	 @CircuitBreaker(name = "movieServiceCircuitBreaker", fallbackMethod = "fallbackRandomActivity")
	public String callExternalApi() {
		//https://www.freetestapi.com/api/v1/movies
	
		if(true) {
			throw new RuntimeException("movie service is failed....!!!!");
			
		}
		return "sucessfull response from movie service....!!";
	}
	public String fallbackRandomActivity(Throwable throwable) {
		return "fallback reponse: external "
				+ "movie service is down. Please try later...!!";
	}
	
}
