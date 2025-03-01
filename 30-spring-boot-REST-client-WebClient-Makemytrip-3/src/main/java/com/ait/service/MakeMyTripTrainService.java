package com.ait.service;

import java.util.List;

import com.ait.bean.TicketResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MakeMyTripTrainService {

	public Flux<TicketResponse> getAllTicketFromIRCTC();
	//public Mono<List<TicketResponse>> getAllTicketFromIRCTC();
	public Mono<TicketResponse> bookTicket(TicketResponse ticketResponse) throws JsonProcessingException;
	
	public Mono<TicketResponse> updateTicket(TicketResponse ticketResponse) throws JsonProcessingException;
	public  Mono<Void> deleteTicket(Long id);

	public Mono<TicketResponse> getTicketById(Long id);
}
