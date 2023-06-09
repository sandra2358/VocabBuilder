package com.sandrayang.vocabbuilderspringboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	Optional<User> findByUsername(String username);
	Optional<User> findByUserID(long UserID);

	
}
