package com.ait.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBean {

	private String name;
	private String dept;
	private int age;
	private int salary;
	private Address address;

}
