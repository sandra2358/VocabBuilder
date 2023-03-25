package com.sandrayang.vocabbuilderspringboot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.Word;

@Repository
public interface ListsRepo extends JpaRepository<Lists,Long>{
	Optional<Lists> findByListID(long listID);
	
	@Query("SELECT w FROM Word w WHERE w.word= ?1")
	List<Word> findSameWord(String word);

}
