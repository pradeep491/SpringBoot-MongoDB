package com.test.mongo.service;

import com.test.mongo.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(String id);
    List<Student> getStudents();
    Student updateStudent(Student student);
    String deleteStudentById(String id);
}
