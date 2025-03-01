package com.ait.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping(value = "/create")
	public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketResponse ticket)
			throws JsonProcessingException {
		TicketResponse bookTicket = trainService.bookTicket(ticket);
		return ResponseEntity.ok(bookTicket);
	}

	@PutMapping(value = "/update")
	public void updateTicket(@RequestBody TicketResponse ticket) throws JsonProcessingException {
		trainService.updateTicket(ticket);
		return;
	}
}
