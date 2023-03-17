package com.sandrayang.vocabbuilderspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrayang.vocabbuilderspringboot.model.Synonym;

@Repository
public interface SynonymRepo extends JpaRepository<Synonym,Long>{

}
