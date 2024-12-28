package com.test.mongo.service;

import com.test.mongo.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface StudentService {
    Student createStudent(Student student);
}
