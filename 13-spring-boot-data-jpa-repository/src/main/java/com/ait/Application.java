package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.bean.Address;
import com.ait.bean.EmployeeBean;
import com.ait.controller.EmployeeController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		EmployeeController empController = ctx.getBean(EmployeeController.class);
	  EmployeeBean emp1=new EmployeeBean(
			  "kumar","DEV",24,75000,new Address("chennai",460016,"TL") 
			  );
	  
	  EmployeeBean emp2=new EmployeeBean(
			  "admin","admin",21,85000,new Address("chennai",460016,"TL") 
			  );
	
	//  empController.registerEmployee(emp1);
	// empController.registerEmployee(emp2);
	
	  empController.getAllEmployee(1, 3);
	  
	  empController.getEmployeeByID(52);
	  empController.getEmployeeByDeptAndSalary("DEV", 75000);
	}

}
