package com.ait.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.beans.TrainTicket;
import com.ait.service.TrainTicketService;
import com.ait.util.RestConstant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Train Ticket controller" ,description = "using this controller you can book the train ticket")
public class TrainTicketController {

	@Autowired
	private TrainTicketService ticketService;

	// get all ticket
	@Operation(summary = "Get all tickets", description = "Retrive a list of tickets")
	@ApiResponse(responseCode = "200", description = "sucessfully retrive tickets",
	        content = {
	        		@Content(mediaType = "application/json",
	        		        schema = @Schema(implementation = TrainTicket.class)),
	        		@Content(mediaType = "application/xml",
    		        schema = @Schema(implementation = TrainTicket.class)),
	        })
	@GetMapping(value = RestConstant.GET_ALL_TICKET,
	consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<TrainTicket>> getAllTrainTickets() {
		List<TrainTicket> allTrainTickets = ticketService.getAllTrainTickets();
		return ResponseEntity.ok(allTrainTickets);
	}
	
	       // get  ticket by id
	// get all ticket
	@Operation(summary = "Get  ticket by id ", description = "Retrive  tickets using ticket id")
	@ApiResponse(responseCode = "200", description = "sucessfully retrive tickets",
	        content = @Content(mediaType = "application/json",
	        schema = @Schema(implementation = TrainTicket.class)))
		@GetMapping(value = RestConstant.GET_TICKET_BY_ID,
				produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<TrainTicket> getTrainTicketsById(@PathVariable Long id) {
			 TrainTicket trainTicketsById = ticketService.getTrainTicketsById(id);
			return ResponseEntity.ok(trainTicketsById);
		}
		
	 //create ticket
        @PostMapping(value = RestConstant.CREATE_TICKET,
    			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
    			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<TrainTicket>createTicket
		                                                                 (@RequestBody TrainTicket trainTicket){
			TrainTicket ticket = ticketService.createTicket(trainTicket);	
			return ResponseEntity.ok(ticket);	
		}
        //delete ticket
        @DeleteMapping(value=RestConstant.DELETE_TICKET,
    			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
    			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
        public ResponseEntity<String>  deleteTicket(@PathVariable Long id){
        	ticketService.deleteTicketsById(id);
			return ResponseEntity.ok("Ticket deleted successfully..............!!!"+id);
        }
        
      //update ticket
        @PutMapping(value = RestConstant.UPDATE_TICKET,
    			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
    			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<TrainTicket>updateTicket
		                                                                 (@RequestBody TrainTicket trainTicket){
			TrainTicket ticket = ticketService.updateTicket(trainTicket);
			return ResponseEntity.ok(ticket);	
		}
		
		
		
		
		
}
