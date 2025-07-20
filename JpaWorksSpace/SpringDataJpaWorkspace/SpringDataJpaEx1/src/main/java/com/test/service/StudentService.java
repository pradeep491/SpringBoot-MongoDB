package com.test.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.test.entity.Student;

@Component
public interface StudentService {
	
	public List<Student> saveAllStudent(List<Student> studentList);

	List<Student> findStudents(String name);

	List<Student> findStudentsUsingNativeQuery(String name);
}
