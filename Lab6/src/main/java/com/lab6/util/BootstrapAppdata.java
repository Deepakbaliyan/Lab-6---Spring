package com.lab6.util;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.lab6.entity.Roles;
import com.lab6.entity.Student;
import com.lab6.entity.User;
import com.lab6.repository.StudentRepository;
import com.lab6.repository.UserRepository;



@Component
public class BootstrapAppdata {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertStudents(ApplicationReadyEvent event) {
		Student student = new Student();
		student.setFirstName("Anurag");
		student.setLastName("Deshmukh");
		student.setCourse("Java fullStack");
		student.setCountry("India");
		
		Student student1 = new Student();
		student1.setFirstName("Akash");
		student1.setLastName("Raut");
		student1.setCourse("Java");
		student1.setCountry("India");
		
		Student student2 = new Student();
		student2.setFirstName("surendra");
		student2.setLastName("toie");
		student2.setCourse("Angular");
		student2.setCountry("Japan");
		
		this.studentRepository.save(student);
		this.studentRepository.save(student1);
		this.studentRepository.save(student2);
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void addUsers(ApplicationReadyEvent event) {
		
		User anurag = new User();
		anurag.setUsername("anurag");
		anurag.setPassword(this.passwordEncoder.encode("welcome"));
		
		User akash = new User();
		akash.setUsername("akash");
		akash.setPassword(this.passwordEncoder.encode("welcome"));
		
		Roles userRole = new Roles();
		userRole.setName("ROLE_USER");
		
		Roles adminRole = new Roles();
		adminRole.setName("ROLE_ADMIN");
		
		Roles anuragUserRole = new Roles();
		anuragUserRole.setName("ROLE_USER");
		
		List<Roles> akashRoles = akash.getRoles();
		akashRoles.add(userRole);
		
		List<Roles> anuragRoles = anurag.getRoles();
		anuragRoles.add(adminRole);
		anuragRoles.add(anuragUserRole);
		
		this.userRepository.save(akash);
		this.userRepository.save(anurag);
		
	}
	
}

