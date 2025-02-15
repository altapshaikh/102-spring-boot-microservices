package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.bean.EmployeeBean;
import com.ait.service.EmployeeService;

@Component
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	public EmployeeBean registerEmployee(EmployeeBean employee) {
		EmployeeBean employe=empService.registerEmployee(employee);
		return employe;
	}
	//find all record
	public List<EmployeeBean> getAllEmployee(int page, int size) {
		List<EmployeeBean> allEmployee = empService.getAllEmployee(page, size);
	return allEmployee;
	}
	public EmployeeBean getEmployeeByID(int id) {
		EmployeeBean employeeById = empService.findEmployeeById(id);
		return employeeById;
	}
	
	public EmployeeBean getEmployeeByDeptAndSalary(String dept, int salary) {
		EmployeeBean employee = empService.
				                                        getEmployeeByDeptAndSalary(dept, salary);
		return employee;
	}
	
	
}
