package com.sandrayang.vocabbuilderspringboot.service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.User;
import com.sandrayang.vocabbuilderspringboot.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public Optional<User> findByUsername(String username){
		return userRepo.findByUsername(username);
	};
	
	  
	public boolean addUser(User user){
		Optional<User> userOptional = findByUsername(user.getUsername());
		if (userOptional.isEmpty()) {
			int strength = 10;
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
			String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(hashPassword);
			userRepo.save(user);
			return true;
		} else {
			return false; 
		}
	}
	
	public boolean verifyCredentials(String username, String password) {
		
		Optional<User> userOptional = userRepo.findByUsername(username);
		System.out.println(userOptional.isEmpty() + " useroptional empty?");
	
		// check if a user is found by email and is the password matches with the hashed password
		int strength = 10;
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom()); // create the password encoder
		if(userOptional.isPresent() && bCryptPasswordEncoder.matches(password, userOptional.get().getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void subscribeList(Lists list, User user){
		Set<Lists> subscribedList = user.getSubscribedList();
		subscribedList.add(list);
		user.setSubscribedList(subscribedList);
	}
	
	public void unsubscribeList(Lists list, User user){
		Set<Lists> subscribedList = user.getSubscribedList();
		subscribedList.remove(list);
		user.setSubscribedList(subscribedList);
	}
}
