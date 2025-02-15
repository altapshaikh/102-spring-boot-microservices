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
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ait.bean.TicketResponse;
import com.ait.service.MakeMyTripTrainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
@Service
public class MakeMyTripTrainServiceImpl implements MakeMyTripTrainService {
@Autowired
	RestClient restClient;
 private static final String url="http://localhost:5555/";
	@Override
	public List<TicketResponse> getAllTicketFromIRCTC() {
		 List<TicketResponse> body = restClient.get() // GET request
		.uri(url+"/tickets")                //URL
		.retrieve()                        //execute request and retrieve the response
		.body(new ParameterizedTypeReference<List<TicketResponse>>() {});  
		 
		 //convert the response to a string
		System.out.println(body);
		return body;
	}

	@Override
	public TicketResponse bookTicket(TicketResponse ticket) throws JsonProcessingException {
		/*
		 * TicketResponse body = restClient.post() .uri(url+"/ticket") .body(ticket)
		 * .retrieve() .body(TicketResponse.class);
		 */
		 ResponseEntity<TicketResponse> entity = restClient.post()
				.uri(url+"/ticket")
				.body(ticket)
				.retrieve()
				.toEntity(new ParameterizedTypeReference<TicketResponse>() {});
		if(entity.getStatusCodeValue()==200) {
			System.out.println( entity.getBody());
		}
		
		return  entity.getBody();
	}

	@Override
	public TicketResponse updateTicket(TicketResponse ticket) throws JsonProcessingException {
		TicketResponse body = restClient.put()
		.uri(url+"/ticket")
		.body(ticket)
		.retrieve()
		.body(TicketResponse.class);
		return body;
	}

	@Override
	public void deleteTicket(Long id) {
		ResponseEntity<Void> bodilessEntity = restClient.delete()
		.uri(url+"/ticket/10")
		.retrieve()
		.toBodilessEntity();
		
	}

	@Override
	public TicketResponse getTicketById(Long id) {
	/**
	 * 	TicketResponse body = restClient.get()
	.uri(url+"ticket/"+id)
		.retrieve()
		.onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
			throw new HttpClientErrorException(res.getStatusCode()); 
		})
		.body(TicketResponse.class);
	 */
		
		TicketResponse body = restClient.get()
				.uri(url+"ticket/"+id)
				.header("Accept", "application/xml")
					.retrieve()
					.onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
						throw new HttpClientErrorException(res.getStatusCode()); 
					})
					.body(TicketResponse.class);
		
		return body;
	}

}
