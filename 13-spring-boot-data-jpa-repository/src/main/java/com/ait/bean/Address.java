package com.ait.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	private String city;
	private int pincode;
	private String state;
}
