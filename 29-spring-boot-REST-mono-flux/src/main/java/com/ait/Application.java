package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.service.MonoService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		MonoService bean = run.getBean(MonoService.class);
		
		bean.monoExamples();
		bean.fluxExamples();
	
	}

}
