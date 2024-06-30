package com.lab6.service;

import java.util.List;

import com.lab6.entity.Student;

public interface StudentService {

	public Student addStudents(Student student);
	
	public List<Student> listAllStudent();
	
	public Student findById(int id);
	
	public Student updateStudent(int id, Student student);
	
	public void deleteStudent(int id);
}

