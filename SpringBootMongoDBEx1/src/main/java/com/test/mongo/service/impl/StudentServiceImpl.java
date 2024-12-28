package com.test.mongo.service.impl;

import com.test.mongo.entity.Student;
import com.test.mongo.repository.StudentRepository;
import com.test.mongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }
}
