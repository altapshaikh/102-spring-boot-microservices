package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.beans.Student;
import com.ait.controller.StudentController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		StudentController student = run.getBean(StudentController.class);
	
		Student s1=new Student();
		
		s1.setName("Rani");
		s1.setEmail("rani123@gmail.com");
		s1.setAddress("hyd");
		s1.setYear("3");

		Student s2=new Student();
		
		s2.setName("Raja");
		s2.setEmail("raja123@gmail.com");
		s2.setAddress("hyd");
		s2.setYear("3");
		student.saveStudent(s1);
		student.saveStudent(s2);
		
		
	}

}
