package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.entity.Student;
import com.test.service.StudentService;

@RestController
@RequestMapping(value = "/")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("studentData/saveallstudents")
	@ResponseBody
	public List<Student> saveAllStudents(@RequestBody List<Student> studentList) {
		List<Student> studentResponse = (List<Student>) studentService.saveAllStudent(studentList);
		return studentResponse;
	}

	@GetMapping("/findStudents/{name}")
	@ResponseBody
	public List<Student> findStudents(@PathVariable String name) {
		List<Student> studentResponse = (List<Student>) studentService.findStudents(name);
		return studentResponse;
	}

	@GetMapping("/findStudentsUsingNativeQuery/{name}")
	@ResponseBody
	public List<Student> findStudentsUsingNativeQuery(@PathVariable String name) {
		List<Student> studentResponse = (List<Student>) studentService.findStudentsUsingNativeQuery(name);
		return studentResponse;
	}

}
