package com.test.mongo.service.impl;

import com.test.mongo.entity.Student;
import com.test.mongo.repository.StudentRepository;
import com.test.mongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public String deleteStudentById(String id) {
        repository.deleteById(id);
        return "Student has been deleted for the id-"+id;
    }

}
