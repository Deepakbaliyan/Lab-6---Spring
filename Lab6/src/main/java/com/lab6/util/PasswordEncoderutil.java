package com.lab6.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderutil {

	public static void main(String[] args) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawText = "welcome";
		String password1=passwordEncoder.encode(rawText);
		String password2=passwordEncoder.encode(rawText);
		String password3=passwordEncoder.encode(rawText);
		String password4=passwordEncoder.encode(rawText);
		
		System.out.println(password1);
		System.out.println(password2);
		System.out.println(password3);
		System.out.println(password4);
		System.out.println(passwordEncoder.matches(rawText, password4));
	}
}

