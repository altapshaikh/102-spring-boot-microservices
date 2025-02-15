package com.ait.service;

import java.util.List;

import com.ait.beans.TrainTicket;

public interface TrainTicketService {

	//get all ticket
	public List<TrainTicket>getAllTrainTickets();
	
	//get  ticket by id
	public TrainTicket getTrainTicketsById(Long id);
		
	//create ticket
	public TrainTicket createTicket(TrainTicket trainTicket);
	
	   //delete ticket
		public void deleteTicketsById(Long id);
		
	//update ticket
	public TrainTicket updateTicket(TrainTicket trainTicket);
}
