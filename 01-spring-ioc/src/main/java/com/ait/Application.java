package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ait.beans.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(Application.class, args);
		
		Student bean = run.getBean(Student.class);
		//Student bean1 = run.getBean(Student.class);
		System.out.println(bean.hashCode());
		//System.out.println(bean1.hashCode());
		
		
		
	}

}
