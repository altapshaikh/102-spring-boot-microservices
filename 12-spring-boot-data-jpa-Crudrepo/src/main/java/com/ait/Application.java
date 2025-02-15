package com.ait;

import java.util.ArrayList;
import java.util.List;

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
		s1.setId(2);
		s1.setName("Rani");
		s1.setEmail("rani123@gmail.com");
		s1.setAddress("hyd");
		s1.setYear("3");
		
	//	Student saveStudent = student.saveStudent(s1);
//		System.out.println(saveStudent);
		System.out.println("#############FIND BY ID ######################3");
		Student studentById = student.getStudentById(2);
		System.out.println(studentById);
		
		System.out.println("#############update student ######################3");
		
		/*
		 * Student updateStudent = student.updateStudent(s1);
		 * System.out.println(updateStudent);
		 */
		
		
System.out.println("#############delete student ######################3");
		
		 student.deleteStudent(252);
		 
		 System.out.println("#############All student ######################3");
			
		 System.out.println(student.getAllStudent());
		
		 System.out.println("#############All student Count ######################3");
			
		 System.out.println(student.getStudentCount());
		 
		 System.out.println("############# student exist ######################3");
			
		if(student.isStudentExist(1000)) {
			System.out.println("student exists with id :");
		}else {
			System.out.println("student not exists with id :");
		}
		
		System.out.println("#############All student Count ######################3");
		
		List<Integer>studentId=new ArrayList<>();
		studentId.add(1);
		studentId.add(52);
		student.deleteMultipleStudents(studentId);
		
		
		 System.out.println("#############Update specific field ######################3");
			
		 System.out.println(student.updateEmail(2, "rani0001@hotmail.com"));
		
		
		 System.out.println("#############find student by name######################3");
			
		 System.out.println(student.findStudentByName("raja"));
		
		
	}

}
