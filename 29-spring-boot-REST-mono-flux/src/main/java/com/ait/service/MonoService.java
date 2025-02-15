package com.ait.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MonoService {

	public void monoExamples() {
		//publisher
		Mono<String> mono1 = Mono.just("hello world");
		//subscriber
		mono1.subscribe(data  -> System.out.println(data) );
		 Mono<Integer> mono2 = Mono.justOrEmpty(Optional.of(10));
		 mono2.subscribe(data  -> System.out.println(data) );
	}
	
	public void fluxExamples() {
		//publisher
	Flux<String> flux = Flux.just("Apple","banana","orange");
//	flux.subscribe(System.out::println);
	flux.subscribe(data->{
		System.out.println(data);
	});
	
	Flux<String> map = flux.map(String::toUpperCase);
	map.subscribe(data->{
		System.out.println(data);
	});
	
	Flux<Integer> range = Flux.range(1, 4);
	Flux<Integer> filter = range.filter(no -> no%2==0);
	filter.subscribe(data->{
		System.out.println(data);
	});
	
	}
	
/**
 * 	Mono--->Used for single async calls (data)
 *     Flux------>multiple async calls (data)
 *     Operators--->map, filter, flatMap
 *     error handling
 *     
 *     Spring WebFlux----->to make async call and perform 
 *                                      non-bloking operation                            
 *                                      using Mono and Flux 
 *     
 */
	
	
	
	
	
	
	
	
	
	
	
	
}
