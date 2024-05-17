package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Student;
import com.test.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/student-list")
	public List<Student> getStudentList() {
		return studentService.getStudentList();
	}

	@GetMapping("/get-student/{id}")
	public Object getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
	
	@PostMapping("/add-student")
	public Object addStudent(@RequestBody Student student) {
//		public Object addStudent(@RequestBody @Valid Student student) {
		return studentService.addStudent(student);
	}
	
	@PostMapping("/update-student")
	public Object updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@GetMapping("/delete-student/{id}")
	public Object deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
}
