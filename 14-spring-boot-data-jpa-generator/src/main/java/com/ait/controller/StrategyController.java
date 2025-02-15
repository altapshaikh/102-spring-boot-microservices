package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.entity.DepartmentEntity;
import com.ait.entity.SalaryEntity;
import com.ait.repository.DepartmentRepository;
import com.ait.repository.SalaryRepository;

@Component
public class StrategyController {

	@Autowired
	DepartmentRepository repository;
	@Autowired
	SalaryRepository salary;

	public void createDepartment() {

		for (int i = 0; i < 10; i++) {
			DepartmentEntity entity = new DepartmentEntity();
			entity.setName("department_" + i);
			repository.save(entity);
		}
	}
	public void insertSalary() {
		for (int i = 0; i < 10; i++) {
			SalaryEntity entity = new SalaryEntity();
			entity.setSalary(55000+i);
			salary.save(entity);
		}
		
	}

}
