package com.test.mongo.controller;

import com.test.mongo.entity.Student;
import com.test.mongo.repository.StudentRepository;
import com.test.mongo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        System.out.println("student document is going to save...!");
        return service.createStudent(student);
    }
}
