package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.component.DataSource;
import com.ait.component.EmailConf;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		DataSource dataSource1 = context.getBean(DataSource.class);
		DataSource dataSource2 = context.getBean(DataSource.class);
		
		System.out.println("singleton instances: "+( dataSource1== dataSource2));
		
		EmailConf email1 = context.getBean(EmailConf.class);
		EmailConf email2 = context.getBean(EmailConf.class);
		
		System.out.println("prototype instances: "+( email1== email2));
	
	
	}

}
