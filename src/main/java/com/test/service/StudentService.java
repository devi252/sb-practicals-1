package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Student;
import com.test.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
//	public static List<Student> studentList = initStudentList();

	public List<Student> getStudentList(){
//		return studentList;
		return studentRepository.findAll();
	}
	
	public Object getStudent(int id) {
//		 Student student = studentList.stream().filter(f -> f.getId() == id).collect(Collectors.toList()).get(0);
//		 
//		 if(student.getId() != 0) {
//			 return student;
//		 } 

		 Optional<Student> findById = studentRepository.findById(id);
		 
		 if(findById.isPresent()) {
			 return findById.get();
		 }		 
		 return "no record found with id : "+id;
	}
	
	public String addStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
		
		if(savedStudent.getId() != 0) {
			return "Student added succesfully";
		}
		return "Student not added";
	}
	
	public String deleteStudent(int id) {
		Optional<Student> findById = studentRepository.findById(id);
		if(findById.isPresent()) {
			studentRepository.delete(findById.get());
			return "Student record with id : " +id +" deleted";
		}
		return "no record found with id : " +id;
	}
	
	public Object updateStudent(Student student) {
		Optional<Student> findById = studentRepository.findById(student.getId());
		if(findById.isPresent()) {
			studentRepository.save(student);
			return "record updated";
		}
		return "no record found to update";
	}
	
	
	
	
	
	
//	static List<Student> initStudentList(){
//		List<Student> list = new ArrayList<>();
//		
//		Student s1 = new Student();
//		s1.setId(1);
//		s1.setName("ishitha");
//		s1.setAge(21);
//		s1.setGender("female");
//		s1.setFee(25000);
//		
//		
//		Student s2 = new Student();
//		s2.setId(2);
//		s2.setName("sanvi");
//		s2.setAge(12);
//		s2.setGender("female");
//		s2.setFee(12000);
//		
//		
//		Student s3 = new Student();
//		s3.setId(3);
//		s3.setName("raghu");
//		s3.setAge(21);
//		s3.setGender("male");
//		s3.setFee(25000);
//		
//		
//		Student s4 = new Student();
//		s4.setId(4);
//		s4.setName("bheem");
//		s4.setAge(19);
//		s4.setGender("male");
//		s4.setFee(15000);
//		
//		list.add(s1);
//		list.add(s2);
//		list.add(s3);
//		list.add(s4);
//		
//		return list;
//	}
}
