package com.ait.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private int id;
	private String name;

	public int getId() {
		return 1;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return "ashok";
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
