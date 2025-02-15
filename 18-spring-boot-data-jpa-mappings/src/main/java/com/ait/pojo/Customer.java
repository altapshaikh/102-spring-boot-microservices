package com.ait.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Customer {
	private int custId;
	private String custName;
	private List<ProductOrder> productOrder;
}
