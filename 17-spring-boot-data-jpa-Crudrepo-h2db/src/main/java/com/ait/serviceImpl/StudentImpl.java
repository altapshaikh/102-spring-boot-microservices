package com.ait.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.beans.Student;
import com.ait.entity.StudentEntity;
import com.ait.repository.StudentRepository;
import com.ait.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		StudentEntity entity=new StudentEntity(); 
		/*
		 * StudentEntity entity=new StudentEntity(); entity.setName(student.getName());
		 * entity.setEmail(student.getEmail()); entity.setYear(student.getYear());
		 * entity.setAddress(student.getAddress());
		 */
		
		BeanUtils.copyProperties(student, entity);	
		StudentEntity save = studentRepository.save(entity);
		BeanUtils.copyProperties(save, student);
		return student;
	}

	@Override
	public Student findStudentById(int id) {
		Student stu=new Student();
		Optional<StudentEntity> student = studentRepository.findById(id);
		StudentEntity studentEntity = student.get();	
		BeanUtils.copyProperties(studentEntity, stu);
		return stu;
	}

	@Override
	public Student updateStudentById(Student student) {
		StudentEntity entity=new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		
		StudentEntity save = studentRepository.save(entity);
		BeanUtils.copyProperties(save, student);
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);

	}

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> student=new ArrayList<>();
		
		List<StudentEntity> allStudent = (List<StudentEntity>) studentRepository.findAll();
		
		allStudent.forEach(data -> {
			Student s1=new Student();
			BeanUtils.copyProperties(data, s1);
			student.add(s1);
		});
		
		return student;
	}

	@Override
	public long countAllStudent() {
		long count = studentRepository.count();
		return count;
	}

	@Override
	public boolean checkStudentExist(int id) {
		boolean existsById = studentRepository.existsById(id);
		return existsById;
	}

	@Override
	public void deleteMultipleStudent(List<Integer> studentId) {
	
		studentRepository.deleteAllById(studentId);
		
	}

	@Override
	public String updateEmail(int id, String email) {
		Optional<StudentEntity> student = studentRepository.findById(id);
		StudentEntity studentEntity = student.get();
		studentEntity.setEmail(email);
		StudentEntity save = studentRepository.save(studentEntity);
		if(save.getEmail().equalsIgnoreCase(email)) {
			return "record updated";
		}else {
			return "record not updated";
		}
	}

	@Override
	public Student findStudentByName(String name) {
		Student student=new Student();
		StudentEntity byName = studentRepository.findByName(name);
		BeanUtils.copyProperties(byName, student);
		
		return student;
	}

}
