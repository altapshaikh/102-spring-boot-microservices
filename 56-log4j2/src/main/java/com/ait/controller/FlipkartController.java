package com.ait.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlipkartController {
	private static final Logger logger=LogManager.getLogger(FlipkartController.class);
	@Autowired
	FlipKartService FlipKartService;
	@GetMapping
	public String bookTicket() {
		logger.trace("TRACE: user started the booking");
		logger.debug("DEBUG user selected seats");
		logger.info("INFO user opt for online payemts");
		logger.warn("WARN user using debit card to payemt");
		logger.error("ERROR payment is sucess or failed");
		logger.fatal("FATAL payment is intiated");
		FlipKartService.Ticket();
		return "ticket booking is failed";
	}

}
