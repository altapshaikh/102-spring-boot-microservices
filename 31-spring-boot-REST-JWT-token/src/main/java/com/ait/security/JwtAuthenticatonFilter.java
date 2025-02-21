package com.ait.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ait.jwt.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticatonFilter extends OncePerRequestFilter {
	
     
	private JwtUtil jwtUtil;
     
      @Autowired
	public JwtAuthenticatonFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			                    FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authorizationHeader = request.getHeader("Authorization");
		
		String username=null;
		String jwtToken=null;
		
		//Bearer 
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")) {
			jwtToken = authorizationHeader.substring(7);
			boolean validateToken = jwtUtil.validateToken(jwtToken);
			if(validateToken) {
				 username = jwtUtil.extractUsername(jwtToken);
			}
			
		}
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication() ==null) {
			if(jwtUtil.validateToken(jwtToken)) {
				
				//authentication logic you can write here
				
				
			}
		}
		filterChain.doFilter(request, response);
	}

}
