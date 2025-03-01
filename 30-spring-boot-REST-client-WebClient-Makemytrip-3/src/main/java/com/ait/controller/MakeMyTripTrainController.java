package com.ait.controller;


import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest.Headers;

import com.ait.bean.TicketResponse;
import com.ait.service.MakeMyTripTrainService;
import com.fasterxml.jackson.core.JsonProcessingException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MakeMyTripTrainController {
	@Autowired
	MakeMyTripTrainService trainService;

	@GetMapping
	public  Flux<TicketResponse> getTicket() {
		 Flux<TicketResponse> allTicketFromIRCTC = trainService.getAllTicketFromIRCTC();
	return allTicketFromIRCTC;
	}
	@GetMapping(value="/ticket/{id}")
	public Mono<TicketResponse> getTicketById(@PathVariable Long id) {
 Mono<TicketResponse> ticketById = trainService.getTicketById(id);
		return ticketById;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Mono<TicketResponse>> createTicket(@RequestBody TicketResponse ticket)
			throws JsonProcessingException {
		Mono<TicketResponse> bookTicket = trainService.bookTicket(ticket);
		return ResponseEntity.ok(bookTicket);
	}

	@PutMapping(value = "/update")
	public Mono<TicketResponse> updateTicket(@RequestBody TicketResponse ticket) throws JsonProcessingException {
		Mono<TicketResponse> bookTicket =trainService.updateTicket(ticket);
		return bookTicket;
	}
	@DeleteMapping("/delete/{id}")
	public void cancelTciket(@PathVariable Long id ,org.springframework.http.HttpRequest req) {
		
		trainService.deleteTicket(id);
	}
	
}
