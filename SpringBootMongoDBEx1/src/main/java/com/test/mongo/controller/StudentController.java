package com.test.mongo.controller;

import com.test.mongo.entity.Student;
import com.test.mongo.repository.StudentRepository;
import com.test.mongo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/getById/{id}")
    public Student getStudent(@PathVariable String id) {
        System.out.println("student document is going to return...!");
        return service.getStudentById(id);
    }
    @GetMapping("/getAll")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        return service.deleteStudentById(id);
    }
}
