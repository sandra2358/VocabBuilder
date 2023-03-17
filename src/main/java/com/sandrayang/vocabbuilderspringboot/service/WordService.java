package com.sandrayang.vocabbuilderspringboot.service;

import java.util.Optional;
import java.util.Set;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.Meaning;
import com.sandrayang.vocabbuilderspringboot.model.Word;
import com.sandrayang.vocabbuilderspringboot.repositories.WordRepo;

@Service
public class WordService {
	
	@Autowired
	WordRepo wordRepo;
	
	public Optional<Word> findByWord(String word){
		return wordRepo.findByWord(word);
	};
	

	  @Autowired @Lazy
	  ListsService listsService;
	  
	  public void addWord(Word word,Lists list){
	    wordRepo.save(word);
	    listsService.addWordToList(word, list);
	  }
	  
	  public void addMeaningToWord(Meaning meaning, Word word){
	    Set<Meaning> meaningList = word.getMeanings();
	    meaningList.add(meaning);
	    word.setMeanings(meaningList);
	  }
	  
	  public Set<Meaning> findMeanings(long wordID){
		  Optional<Word> wordOptional= wordRepo.findWordByWordID(wordID);
		  Word word = wordOptional.get();
		  return word.getMeanings();
	  }
}
