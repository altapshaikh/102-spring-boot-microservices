package com.ait.beans;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
	private String message;
	private LocalDateTime timestamp;
	private int status;
	
	public ErrorResponse(String message, HttpStatus status) {
		this.timestamp=LocalDateTime.now();
		this.message = message;
		this.status = status.value();
	}
}
