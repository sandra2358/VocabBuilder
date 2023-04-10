package com.sandrayang.vocabbuilderspringboot.controller;

import java.net.URI;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sandrayang.vocabbuilderspringboot.DTO.UserDto;
import com.sandrayang.vocabbuilderspringboot.model.User;
import com.sandrayang.vocabbuilderspringboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user){
		boolean isCreated = userService.addUser(user);
		
		if (isCreated) {
			URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/login")
					.build().toUri();
			// if the user is registered successfully, status number = 201
			// body : User user
			return ResponseEntity.created(location).body(user);  
		} else {
			// if the username is in the database, status number: 417
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build(); 
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user){
		String username = user.getUsername();
		String password = user.getPassword();
		
		boolean isVerified = userService.verifyCredentials(username,password);
		System.out.println(isVerified + " is verified?");
		if(isVerified) {
			user = userService.findByUsername(username).get();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userID}").buildAndExpand(user.getUserID()).toUri();
//			return ResponseEntity.ok().build();
			// if the password and email matches, status: 201
			return ResponseEntity.created(location).body(user); 
		} else {
			// the password or email doens't match, status number: 417 
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
//		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/updateProfile")
	public ResponseEntity<User> updateUserProfile(@RequestBody User user){
		
		userService.updateProfile(user);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/updatePassword")
	public ResponseEntity<User> updateUserPassword(@RequestBody User user){
		
		userService.updatePassword(user);
		
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/{userID}")
	public ResponseEntity<User> getUserHome(@PathVariable("userID") long userID) {
		User user = userService.findUserByUserID(userID);
		return ResponseEntity.ok().body(user);
	}
	
	
	
}
