package com.ait.serviceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ait.bean.TicketResponse;
import com.ait.service.MakeMyTripTrainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MakeMyTripTrainServiceImpl implements MakeMyTripTrainService {
	
	@Autowired
	RestTemplate restTemplate;

	//GET
	@Override
	public List<TicketResponse> getAllTicketFromIRCTC() {
		String url="http://localhost:5555/tickets";
		
		String response = restTemplate.getForObject(url,String.class);
		System.out.println(response);
		
		
		ResponseEntity<String> response1 = restTemplate.getForEntity(url, String.class);
		if(response1.getStatusCodeValue()==200) {
			System.out.println(response1.getBody());
		}
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String>request=new HttpEntity<>(headers);
	
				  ResponseEntity<List<TicketResponse>> exchange = restTemplate.exchange(url,HttpMethod.GET, request,new ParameterizedTypeReference<List<TicketResponse>>() {});
			        
				  if(exchange.getStatusCodeValue()==200) {
						System.out.println(exchange.getBody());
					}
		
		return exchange.getBody();
	}

	//POST
	@Override
	public TicketResponse bookTicket(TicketResponse ticket) throws JsonProcessingException {
		String url="http://localhost:5555/ticket";
		//request body
		Map<String, Object>requestBody=new HashMap<>();
		requestBody.put("passengerName", ticket.getPassengerName());
		requestBody.put("trainName", ticket.getTrainName());
		requestBody.put("sourceStation", ticket.getSourceStation());
		requestBody.put("destinationStation", ticket.getDestinationStation());
		requestBody.put("dateOfTravel", ticket.getDateOfTravel());
		requestBody.put("numberOfSeats", ticket.getNumberOfSeats());
		//post for object
	//	String reponse = restTemplate.postForObject(url, requestBody, String.class);
	//	System.out.println(reponse);
		
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper=new ObjectMapper();
		String reqBody = mapper.writeValueAsString(ticket);
		
		HttpEntity<String>request=new HttpEntity<>(reqBody,headers);
		//post for entity
		ResponseEntity<TicketResponse> postForEntity = restTemplate.postForEntity(url, request, TicketResponse.class);
		
		System.out.println(postForEntity.getBody());
		
		ResponseEntity<TicketResponse> exchange = restTemplate.exchange(url,HttpMethod.POST, request,TicketResponse.class);
		System.out.println(exchange.getBody());
		return exchange.getBody();
	}

	@Override
	public TicketResponse updateTicket(TicketResponse ticket) throws JsonProcessingException {
		String url="http://localhost:5555/ticket";
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ObjectMapper mapper=new ObjectMapper();
		String reqBody = mapper.writeValueAsString(ticket);
		HttpEntity<String>request=new HttpEntity<>(reqBody,headers);
		
		    restTemplate.put(url, request);
		    
		    restTemplate.delete("http://localhost:5555/ticket/8");
		    
		return null;
	}
	
	
	
	

}
