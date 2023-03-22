package com.sandrayang.vocabbuilderspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrayang.vocabbuilderspringboot.model.Meaning;

@Repository
public interface MeaningRepo extends JpaRepository<Meaning,Long>{

	

}
