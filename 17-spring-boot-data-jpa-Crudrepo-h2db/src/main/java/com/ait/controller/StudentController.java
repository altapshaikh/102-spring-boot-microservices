package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.beans.Student;
import com.ait.service.StudentService;

@Component
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	public Student saveStudent(Student student) {
		Student saveStudent = studentService.saveStudent(student);
		return saveStudent;
	}
	public Student getStudentById(int id) {
		Student studentById = studentService.findStudentById(id);
		return studentById;
	}
	public Student updateStudent(Student student) {
		Student saveStudent = studentService.updateStudentById(student);
		return saveStudent;
	}
	
	public void deleteStudent(int id) {
		studentService.deleteStudent(id);
	}
	
	public List<Student>getAllStudent(){
		List<Student> allStudent = studentService.getAllStudent();
		return allStudent;
	}
	
	public long getStudentCount() {
		long countAllStudent = studentService.countAllStudent();
		return countAllStudent;
	}
	
	public boolean isStudentExist(int id) {
		boolean checkStudentExist = studentService.checkStudentExist(id);
		return checkStudentExist;
	}
	
	public void deleteMultipleStudents(List<Integer> studentId) {
		studentService.deleteMultipleStudent(studentId);
	}
	
	public String updateEmail(int id, String email) {
		String updateEmail = studentService.updateEmail(id, email);
		return updateEmail;
	}
	
	public Student findStudentByName(String name) {
		return  studentService.findStudentByName(name);
	}
	
	
}
