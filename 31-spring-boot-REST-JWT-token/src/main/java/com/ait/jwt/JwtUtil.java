package com.ait.jwt;


import java.util.Date;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {
	
    @Value("${jwt.secret}")
	private String secretKey;
    
    @Value("${jwt.expirationMS}")
	private long expirationMs;
    
    //generate token
    
    public String generateToken(String username) {	
    	String token = Jwts.builder()
    	            .setSubject(username)
    	            .setIssuedAt(new Date())
    	            .setExpiration(new Date(System.currentTimeMillis()+expirationMs))
    	            .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    	return token;
    	
    }
    
    //validate JWT token
    
    public boolean validateToken(String token) {
    	try {
    	Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token);
    	return true;
    	}catch (JwtException |IllegalArgumentException e) {
			return false;
		}
    }
    
    //extract username from token
    
    public String extractUsername(String token) {
    	String username = Jwts.parser()
      	                                     .setSigningKey(secretKey)
    	                                     .build()
    	                                     .parseClaimsJws(token)
    	                                      .getBody()
    	                                  .getSubject();
    	return username;
    }
    
    
    public Claims getAllClaimsFromToken(String token) {

    	   return Jwts.parser().setSigningKey(secretKey).build()
    			   .parseClaimsJws(token).getBody();

    	}
    
    
 
    
    
    
	
}
