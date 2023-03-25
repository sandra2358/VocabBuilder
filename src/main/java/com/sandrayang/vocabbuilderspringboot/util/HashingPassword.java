package com.sandrayang.vocabbuilderspringboot.util;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashingPassword {
	
	public static void main(String[] args) {
	
	// Example password
	String password = "tom123";
	
	// Encrypting the password
	int strength = 10; // work factor of bcrypt
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom()); // generate an encoder, SecureRandom() act as a salt generator
	String encodedPassword = bCryptPasswordEncoder.encode(password); // encrypted password
	
	System.out.println(encodedPassword);
	
	// Verifying if the password match with the encoded password
	boolean verified = bCryptPasswordEncoder.matches(password, encodedPassword);
	System.out.println(verified);
	
	}

	
}
