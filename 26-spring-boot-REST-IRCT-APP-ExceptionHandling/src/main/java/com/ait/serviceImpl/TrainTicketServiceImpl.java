package com.ait.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.beans.TrainTicket;
import com.ait.entity.TrainTicketEntity;
import com.ait.exception.TicketNotFoundException;
import com.ait.repository.TrainTicketReposiotry;
import com.ait.service.TrainTicketService;

@Service
public class TrainTicketServiceImpl implements TrainTicketService {
	
	@Autowired
	private TrainTicketReposiotry ticketReposiotry;

	@Override
	public List<TrainTicket> getAllTrainTickets() {
		List<TrainTicket>listOfTickets=new ArrayList<>();
		List<TrainTicketEntity> allTickets = ticketReposiotry.findAll();
		allTickets.forEach(  tickets  ->  {
			TrainTicket ticket=new TrainTicket();
			BeanUtils.copyProperties(tickets, ticket);
			listOfTickets.add(ticket);
		});
		
		return listOfTickets;
	}

	@Override
	public TrainTicket getTrainTicketsById(Long id) {
		TrainTicket ticket=new TrainTicket();
		Optional<TrainTicketEntity> trainTicket = ticketReposiotry.findById(id);
		
		if(trainTicket.isPresent()) {
			BeanUtils.copyProperties( trainTicket.get(), ticket);
		}else {
			throw new TicketNotFoundException("Train Ticket not found for this id: "+id);
		}
		return ticket;
	}

	@Override
	public TrainTicket createTicket(TrainTicket trainTicket) {
		TrainTicketEntity ticketEntity=new TrainTicketEntity();
		BeanUtils.copyProperties( trainTicket, ticketEntity);
		TrainTicketEntity ticket = ticketReposiotry.save(ticketEntity);
		BeanUtils.copyProperties( ticket, trainTicket);
		return trainTicket;
	}

	@Override
	public void deleteTicketsById(Long id) {
		ticketReposiotry.deleteById(id);
	}

	@Override
	public TrainTicket updateTicket(TrainTicket trainTicket) {
		TrainTicketEntity ticketEntity=new TrainTicketEntity();
		BeanUtils.copyProperties( trainTicket, ticketEntity);
		TrainTicketEntity tickets = ticketReposiotry.save(ticketEntity);
		BeanUtils.copyProperties( tickets, trainTicket);
		return trainTicket;
	}

}
