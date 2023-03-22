package com.sandrayang.vocabbuilderspringboot.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.Meaning;
import com.sandrayang.vocabbuilderspringboot.model.Word;
import com.sandrayang.vocabbuilderspringboot.repositories.ListsRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.WordRepo;

@Service
public class WordService {
	
	@Autowired
	WordRepo wordRepo;
	
	@Autowired
	ListsRepo listsRepo;
	
	public Optional<Word> findByWord(String word){
		return wordRepo.findByWord(word);
	};
	
	
	public void addWord(Word word,Lists list){
		// add word to Word
		wordRepo.save(word);
		list.addWordToList(word);
	};
	  
	
	  
	public Set<Meaning> findMeanings(long wordID){
		Optional<Word> wordOptional= wordRepo.findWordByWordID(wordID);
		Word word = wordOptional.get();
		return word.getMeanings();
	}
	
}
