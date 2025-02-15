package com.ait.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ait.beans.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
/**
 * 	@ExceptionHandler(TicketNotFoundException.class)
 * @param ticketEx
 * @return
 * public ResponseEntity<String>handleTrainException
	                                                     (TicketNotFoundException ticketEx){
		return new ResponseEntity<>(ticketEx.getMessage(),HttpStatus.NOT_FOUND);
		
	}
 */
	/***
	 * 
	 * @param ticketEx
	 * @return
	 */
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleTrainException
	                                                     (TicketNotFoundException ticketEx){
		ErrorResponse errorResponse=
				  new ErrorResponse(ticketEx.getMessage(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String>handleException
	                                                     (Exception Ex){
		return new ResponseEntity<>(Ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
}
