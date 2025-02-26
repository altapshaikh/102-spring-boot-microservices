package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.bean.Message;
import com.ait.service.KafkaProducerService;

@RestController
public class TestController {
	
	@Autowired
	private KafkaProducerService kafkaService;
@PostMapping(value = "/send")
	public String sendMessage(@RequestBody Message message) {
		kafkaService.sendMessage(message.getTopicName(), message.getMsg());
		return "msg send sucessfully.........!!!";
	}

//single node installation
//zookeper and kafka
//arch of kafka
//producer
//consumer
//kafka cluster
//kafka broker
//offset
//topic
//partitions
//consumer group
//send data through a key
//offset explorer tool for kafka





	
	
}
