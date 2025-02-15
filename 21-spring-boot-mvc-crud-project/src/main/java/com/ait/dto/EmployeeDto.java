package com.ait.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	private long empId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private String department;
	private boolean agreeToTerms;
}
