package com.ait.service;

import java.util.List;

import com.ait.bean.TicketResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MakeMyTripTrainService {

	public List<TicketResponse>getAllTicketFromIRCTC();
	
	public TicketResponse bookTicket(TicketResponse ticketResponse) throws JsonProcessingException;
	
	public TicketResponse updateTicket(TicketResponse ticketResponse) throws JsonProcessingException;
	public void deleteTicket(Long id);

	public TicketResponse getTicketById(Long id);
}
