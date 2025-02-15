package com.ait.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_order")
@Data
public class OrderEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_seq_generator")
   @SequenceGenerator(name = "order_seq_generator",sequenceName = "product_seq",allocationSize = 1)
	private int order_id;
	private String product;
}
