package com.ait.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "salary")
@Data
public class SalaryEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
     private int salary;
	
}
