package com.ait.serviceImpl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.reactive.function.client.WebClient;

import com.ait.bean.TicketResponse;
import com.ait.service.MakeMyTripTrainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
@Service
public class MakeMyTripTrainServiceImpl implements MakeMyTripTrainService {
@Autowired
	WebClient webClient;

	@Override
	public    Flux<TicketResponse> getAllTicketFromIRCTC() {
		  Flux<TicketResponse> bodyToFlux = webClient.get() .uri("/tickets")
		  .retrieve() .bodyToFlux(TicketResponse.class);
		return bodyToFlux;
	}

	@Override
	public Mono<TicketResponse> bookTicket(TicketResponse ticket) throws JsonProcessingException {
		Mono<TicketResponse> bodyToMono = webClient.post()
				          .uri("/ticket")
		                  .body(Mono.just(ticket),TicketResponse.class)
		                  .retrieve()
		                  .bodyToMono(TicketResponse.class);
		
		return  bodyToMono;
	}

	@Override
	public Mono<TicketResponse> updateTicket(TicketResponse ticket) throws JsonProcessingException {
		
		Mono<TicketResponse> bodyToMono = webClient.put()
		          .uri("/ticket")
                .body(Mono.just(ticket),TicketResponse.class)
                .retrieve()
                .bodyToMono(TicketResponse.class);
		return bodyToMono;
	
	}

	@Override
	public  Mono<Void> deleteTicket(Long id) {
	  Mono<Void> bodyToMono = webClient.delete()
			 .uri("/ticket/{id}",id)
			 .retrieve()
			 .bodyToMono(Void.class);
	  bodyToMono.subscribe(data ->{
		 System.out.println(data);
	  });
	  return bodyToMono;
	 
	}

	

	@Override
	public Mono<TicketResponse> getTicketById(Long id) {
	  Mono<ResponseEntity<TicketResponse>> entity = webClient.get()
			     
				.uri("/ticket/"+id)
				.retrieve()
				.toEntity(TicketResponse.class);
	return null;
	  
	 
	}

}
