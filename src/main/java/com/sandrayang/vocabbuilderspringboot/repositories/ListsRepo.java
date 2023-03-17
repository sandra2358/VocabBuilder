package com.sandrayang.vocabbuilderspringboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrayang.vocabbuilderspringboot.model.Lists;

@Repository
public interface ListsRepo extends JpaRepository<Lists,Long>{
	Optional<Lists> findByListID(long listID);
	
}
