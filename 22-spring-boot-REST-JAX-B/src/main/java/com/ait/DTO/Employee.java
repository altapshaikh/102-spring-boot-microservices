 package com.ait.DTO;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employee")
@XmlType(propOrder = {"id","name","salary","skills"})
public class Employee {
	private int id;
	private String name;
	
	
	private double Salary;
	
	
	
	private List<String>skills;

	public Employee(int id, String name, double salary, List<String> skills) {
		this.id = id;
		this.name = name;
		Salary = salary;
		this.skills = skills;
	}
	public Employee() {
	
	}
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
	@XmlElementWrapper(name = "skills")
	@XmlElement(name ="skill" )
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
}
