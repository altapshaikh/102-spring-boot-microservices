package com.ait.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_data")
public class StudentEntity { // student_entity
	@Id
	@Column(name = "student_id",length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "student_name",length = 50,nullable = false)
	private String name;
	private String year;
	private String email;
	private String address;

	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", year=" + year + ", email=" + email + ", address=" + address + "]";
	}

}
