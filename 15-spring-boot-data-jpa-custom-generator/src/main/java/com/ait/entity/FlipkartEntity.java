package com.ait.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "flipkart")
@Data
public class FlipkartEntity {
	@Id
	@GeneratedValue(generator = "flipkart-id-generator")
	@GenericGenerator(name = "flipkart-id-generator",
	                                   strategy = "com.ait.util.FlipkartIdGenerator")
	private String id;
	private String product;

}
