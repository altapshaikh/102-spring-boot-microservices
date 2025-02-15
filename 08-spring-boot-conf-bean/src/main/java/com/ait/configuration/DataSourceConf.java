package com.ait.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ait.component.DataSource;
import com.ait.component.EmailConf;

@Configuration
public class DataSourceConf {

	@Bean
	@Scope("singleton")
	public DataSource data() {
		return new DataSource();
	}
	
	@Bean
	@Scope("prototype")
	public EmailConf email() {
		return new EmailConf();
	}

}
