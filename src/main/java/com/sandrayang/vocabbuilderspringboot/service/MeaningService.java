package com.sandrayang.vocabbuilderspringboot.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Meaning;
import com.sandrayang.vocabbuilderspringboot.model.Word;
import com.sandrayang.vocabbuilderspringboot.repositories.MeaningRepo;

@Service
public class MeaningService {
	
	@Autowired
	MeaningRepo meaningRepo;
	@Autowired
	WordService wordService;
	  
	public void addMeaning(Meaning meaning, Word word){
	  meaningRepo.save(meaning);
	  Set<Word> words = meaning.getWords();
	  words.add(word);
	  meaning.setWords(words);
	  wordService.addMeaningToWord(meaning, word);
	}

}
