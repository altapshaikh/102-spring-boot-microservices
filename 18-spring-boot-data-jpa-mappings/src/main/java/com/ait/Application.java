package com.ait;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.controller.OrderController;
import com.ait.pojo.Customer;
import com.ait.pojo.ProductOrder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		OrderController order = ctx.getBean(OrderController.class);
		Customer c1=new Customer();
		ProductOrder product=new ProductOrder();
		product.setDescription("household");
		product.setProductName("dustbin");
		
		ProductOrder product1=new ProductOrder();
		product1.setDescription("fashion");
		product1.setProductName("smart watch");
		
		List<ProductOrder>productOrderList=new ArrayList<>();
		
		productOrderList.add(product1);
		productOrderList.add(product);
		
	    c1.setCustName("raja");
	    
	    c1.setProductOrder(productOrderList);
		
		Customer customer = order.createCustomer(c1);
		System.out.println(customer);
		
		
		Customer c2=new Customer();
		 product=new ProductOrder();
		product.setDescription("fashion");
		product.setProductName("T-shirt");
		c2.setCustName("rani");
		productOrderList.add(product);
		c2.setProductOrder(productOrderList);
		
		Customer customer2 = order.createCustomer(c2);
		System.out.println(customer2);
		
		
		//fecth all customer 
		
		List<Customer> allCustomer = order.getAllCustomer();
		
	//	allCustomer.forEach(System.out::println);
		
		
	
	}

}
