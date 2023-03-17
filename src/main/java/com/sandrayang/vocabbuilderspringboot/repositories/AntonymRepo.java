package com.sandrayang.vocabbuilderspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrayang.vocabbuilderspringboot.model.Antonym;

@Repository
public interface AntonymRepo extends JpaRepository<Antonym,Long>{

}

