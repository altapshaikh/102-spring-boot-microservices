package com.ait.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class FlipKartService {
	private static final Logger logger=LogManager.getLogger(FlipKartService.class);
	
	public void Ticket() {
		logger.error("ERROR payment is sucess or failed");
		logger.fatal("FATAL payment is intiated");
	}
}
