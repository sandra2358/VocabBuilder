package com.sandrayang.vocabbuilderspringboot.service;

import java.util.Set;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Meaning;
import com.sandrayang.vocabbuilderspringboot.model.Word;
import com.sandrayang.vocabbuilderspringboot.repositories.MeaningRepo;

@Service
public class MeaningService {
	
	@Autowired
	MeaningRepo meaningRepo;
	  
	public void addMeaning(Meaning meaning, Word word){
		try {
			meaningRepo.save(meaning);
			meaning.addWordToMeaning(word);
			word.addMeaningToWord(meaning);
		}
		catch(Exception e){};
	}
	
	public void deleteMeaning(Meaning meaning) {
		meaning.getWords().forEach(word -> word.removeMeaningFromWord(meaning));
		meaningRepo.delete(meaning);
		
	}
}
