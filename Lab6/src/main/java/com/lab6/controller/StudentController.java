package com.lab6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab6.entity.Student;
import com.lab6.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping()
	public List<Student> listAll() {
		return this.service.listAllStudent();
	}
	
	@GetMapping("/{id}")
	public Student findperticulerStudent(@PathVariable("id") int id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public  Student addStudent(@RequestBody Student student) {
		return this.service.addStudents(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		return this.service.updateStudent(id,student);
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		this.service.deleteStudent(id);
	}
	
}
