package com.lab6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab6.entity.Student;
import com.lab6.repository.StudentRepository;

@Service
public class StudentServiceImpll implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student addStudents(Student student) {
		Student newStudent = this.repo.save(student);
		return newStudent;
	}

	@Override
	public List<Student> listAllStudent() {
		List<Student> allStudents = this.repo.findAll();
		return allStudents;
	}

	@Override
	public Student updateStudent(int id, Student student) {
		Student updatedStudent = this.findById(id);
		updatedStudent.setFirstName(student.getFirstName());
		updatedStudent.setLastName(student.getLastName());
		updatedStudent.setCourse(student.getCourse());
		updatedStudent.setCountry(student.getCountry());
		this.repo.save(updatedStudent);
		return updatedStudent;
	}

	@Override
	public void deleteStudent(int id) {
		this.repo.deleteById(id);

	}

	@Override
	public Student findById(int id) {
		return this.repo.findById(id).stream()
				.filter(stud-> stud.getId()==id)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Invalid ID Passed"));
	}

}
