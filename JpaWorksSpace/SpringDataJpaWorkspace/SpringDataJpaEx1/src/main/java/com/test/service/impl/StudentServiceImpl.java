package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Student;
import com.test.repo.StudentRepository;
import com.test.service.StudentService;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Transactional
	@Override
	public List<Student> saveAllStudent(List<Student> studentList) {
		List<Student> list = (List<Student>) repository.saveAll(studentList);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> findStudents(String name) {
		List<Student> list = repository.findStudents(name);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> findStudentsUsingNativeQuery(String name) {
		List<Student> list = repository.findStudentsUsingNativeQuery(name);
		return list;
	}
}
