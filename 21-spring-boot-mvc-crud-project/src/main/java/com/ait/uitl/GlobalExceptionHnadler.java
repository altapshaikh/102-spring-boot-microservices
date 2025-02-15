package com.ait.uitl;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHnadler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(Exception ex, Model model) {
            model.addAttribute("error", ex.getMessage());
            return "error-500";
	}
	
	
	  @ExceptionHandler(IllegalArgumentException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST) public String
	  handleBadRequest(IllegalArgumentException ex, Model model) {
	  model.addAttribute("error", ex.getMessage()); return "error-400";
	  }
	 
	@ExceptionHandler(NoResourceFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFounRequest(NoResourceFoundException ex, Model model) {
            model.addAttribute("error", ex.getMessage());
            return "error-404";
	}
	@ExceptionHandler(EmployeeNotFoundExaception.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String handleBadRequest(EmployeeNotFoundExaception ex, Model model) {
            model.addAttribute("error", ex.getMessage());
            return "error-406";
	}
}
