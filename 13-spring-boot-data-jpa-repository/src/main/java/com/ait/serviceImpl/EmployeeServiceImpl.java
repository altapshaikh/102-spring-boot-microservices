package com.ait.serviceImpl;


import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ait.bean.EmployeeBean;
import com.ait.entity.EmployeeEntity;
import com.ait.repository.EmployeeRepository;
import com.ait.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public EmployeeBean findEmployeeById(int id) {
		EmployeeBean bean=new EmployeeBean();
		EmployeeEntity employeeById = empRepository.getEmployeeById(id);
		System.out.println(employeeById);
		BeanUtils.copyProperties(employeeById, bean);
		return bean;
	}

	@Override
	public List<EmployeeBean> getAllEmployee(int page, int size) {
		EmployeeBean bean = new EmployeeBean();
	//	Pageable pageable = (Pageable) PageRequest.of(page, size);
		// Page<EmployeeEntity> entity = empRepository.findByDept("DEV",pageable);

		// Page<EmployeeEntity> all = empRepository.findAll(pageable);
		// List<EmployeeEntity> content = all.getContent(); 
	//	 System.out.println(content);
	//	 Pageable pageable1 = (Pageable) PageRequest.of(2, 2);
	//	 Page<EmployeeEntity> alll = empRepository.findAll(pageable1);
	//	 List<EmployeeEntity> content1 = alll.getContent(); 
	//	 System.out.println(content1);
		
	//	Pageable pageable = (Pageable) PageRequest.of(page, size,Sort.by(Sort.Order.asc("name")));
	//	Pageable pageable = (Pageable) PageRequest.of(page, 5,Sort.by(Sort.Order.desc("name")));
	//	Page<EmployeeEntity> all = empRepository.findAll(pageable);
	List<EmployeeEntity> content = empRepository.findAll(Sort.by("salary"));
	
		System.out.println(content);
		 
		 
		 
		return null;
	}

	@Override
	public EmployeeBean registerEmployee(EmployeeBean employee) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		EmployeeEntity save = empRepository.save(entity);
		BeanUtils.copyProperties(save, employee);
		return employee;
	}

	@Override
	public EmployeeBean updateEmployee(EmployeeBean employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeBean getEmployeeByDeptAndSalary(String dept, int salary) {
		EmployeeBean bean=new EmployeeBean();
		List<EmployeeEntity> employeeByDeptAndSalary = empRepository.getEmployeeByDeptAndSalary(dept, salary);
		System.out.println(employeeByDeptAndSalary);
		//BeanUtils.copyProperties(employeeByDeptAndSalary, bean);
		
		return bean;
	}

}
