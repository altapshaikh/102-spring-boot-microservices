package com.ait.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.bean.TicketResponse;
import com.ait.service.MakeMyTripTrainService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MakeMyTripTrainController {
	@Autowired
	MakeMyTripTrainService trainService;

	@GetMapping
	public void getTicket() {
		trainService.getAllTicketFromIRCTC();
	}
	@GetMapping(value="/ticket/{id}")
	public TicketResponse getTicketById(@PathVariable Long id) {
		TicketResponse ticketById = trainService.getTicketById(id);
		return ticketById;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketResponse ticket)
			throws JsonProcessingException {
		TicketResponse bookTicket = trainService.bookTicket(ticket);
		return ResponseEntity.ok(bookTicket);
	}

	@PutMapping(value = "/update")
	public TicketResponse updateTicket(@RequestBody TicketResponse ticket) throws JsonProcessingException {
		TicketResponse updateTicket = trainService.updateTicket(ticket);
		return updateTicket;
	}
	@DeleteMapping("/delete/{id}")
	public void cancelTciket(@PathVariable Long id) {
		trainService.deleteTicket(id);
	}
	
}
