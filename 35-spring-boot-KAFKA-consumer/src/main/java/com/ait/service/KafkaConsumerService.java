package com.ait.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "ipl", groupId = "my-group")
	public void listen(String msg) {
		//Business logic from this method
		System.out.println(msg);
	}
}
