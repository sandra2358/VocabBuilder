package com.sandrayang.vocabbuilderspringboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrayang.vocabbuilderspringboot.model.Word;

@Repository
public interface WordRepo extends JpaRepository<Word,Long>{
	Optional<Word> findByWord(String word);
	Optional<Word> findWordByWordID(long wordID);
}
