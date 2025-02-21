package com.ait.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.jwt.JwtUtil;
import com.ait.pojo.LoginDetails;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
	@Autowired
	JwtUtil jwtUtil;
	
	//endpoint to generate token
	@PostMapping(value = "/login")
	public ResponseEntity<String>login
	                                                 (@RequestBody LoginDetails details){
		//service logic details --->username and password
		String token = jwtUtil.generateToken(details.getEmail());
		return  ResponseEntity.ok(token);	
	}
	
	// endpoint for verify token
	@GetMapping(value = "/verify")
	public ResponseEntity<String> verifyToken(@RequestHeader("Authorization") String token) {

		if (token.startsWith("Bearer")) {
			token = token.substring(7);
		}
		
		boolean isValid = jwtUtil.validateToken(token);
		if (isValid) {
			return ResponseEntity.ok("Token is valid");
		} else {
			return ResponseEntity.ok("Token is not valid");
		}
	}
@GetMapping(value = "/claims")
	public Claims getClaims(@RequestHeader("Authorization") String token) {
	
	if (token.startsWith("Bearer")) {
		token = token.substring(7);
	}  
	
	Claims allClaimsFromToken = jwtUtil.getAllClaimsFromToken(token);
	return allClaimsFromToken;
	}
}
