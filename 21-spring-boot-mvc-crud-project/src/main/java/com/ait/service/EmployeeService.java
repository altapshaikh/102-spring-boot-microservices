package com.ait.service;

import java.util.List;

import com.ait.dto.EmployeeDto;

import jakarta.servlet.http.HttpSession;

public interface EmployeeService {

	//for register
	public EmployeeDto registerEmployee(EmployeeDto dto);
	//for update
	public EmployeeDto updateEmployee(EmployeeDto dto);
	//for delete
	public boolean deleteEmployee(long id);
	//get all employeee
	public List<EmployeeDto>fetchAllEmployee();
	
	public EmployeeDto getEmployeeById(Long id);
	
	public String loginEmployee(String email, String password);
	public void handleHttpSession(Long id,HttpSession session);
	
}
