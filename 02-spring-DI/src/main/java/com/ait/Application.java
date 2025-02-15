package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ait.util.Flipkart;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(Application.class, args);
		
		Flipkart flipkart = run.getBean(Flipkart.class);
		
		flipkart.sendCourier("1001", "hyderabad,  TS");
		
	}

}
