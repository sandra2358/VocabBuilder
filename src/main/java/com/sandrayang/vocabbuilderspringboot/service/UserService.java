package com.sandrayang.vocabbuilderspringboot.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
	

	  
	public void addListToCreatedList(Lists list,User user){
		Set<Lists> createdList = user.getCreatedList();
		createdList.add(list);
		user.setCreatedList(createdList);
	}
	  
	public void addUser(User user){
		userRepo.save(user);
	}
	
}
