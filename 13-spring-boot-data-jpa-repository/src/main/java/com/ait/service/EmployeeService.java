package com.ait.service;

import java.util.List;

import com.ait.bean.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean findEmployeeById(int id);

	public List<EmployeeBean> getAllEmployee(int page, int size);

	public EmployeeBean registerEmployee(EmployeeBean employee);

	public EmployeeBean updateEmployee(EmployeeBean employee);
	
	public EmployeeBean getEmployeeByDeptAndSalary(String dept,int salary);

}
