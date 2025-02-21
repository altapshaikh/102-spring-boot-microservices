package com.ait.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ait.jwt.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private JwtUtil jwtUtil;
	public SecurityConfig(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().
		disable().
		authorizeRequests().
		requestMatchers("/auth/**")
		.permitAll()
		.anyRequest().authenticated();

		http.addFilterBefore(new JwtAuthenticatonFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	

}
