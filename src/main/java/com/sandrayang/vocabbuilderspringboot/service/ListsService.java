package com.sandrayang.vocabbuilderspringboot.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.Meaning;
import com.sandrayang.vocabbuilderspringboot.model.User;
import com.sandrayang.vocabbuilderspringboot.model.Word;
import com.sandrayang.vocabbuilderspringboot.repositories.ListsRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.MeaningRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.UserRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.WordRepo;

@Service
public class ListsService {
	
	@Autowired 
	ListsRepo listsRepo;
	@Autowired
	WordRepo wordRepo;
	@Autowired
	MeaningRepo meaningRepo;
	@Autowired
	UserRepo userRepo;
	
	public Optional<Lists> findByListID(long listID){
		return listsRepo.findByListID(listID);
	};
	
	
	  
	public void addList(Lists list){
		listsRepo.save(list);
		User creator = list.getCreator();
		creator.addCreatedList(list);
	}


	public Set<Word> findWords(Lists list){
		return list.getWords();
	}
	
	  
	public long findNumWords(Lists list){
		return list.getWords().size();
	}
	
	  
	// delete word if the word doesn't exist in other lists
	public void deleteWordFromList(Word word,Lists list){
	    list.removeWordFromList(word);
	    Set<Meaning> meaningList = word.getMeanings();
	    if (word.getList().size() == 0) {
	    	wordRepo.delete(word);
	    }
	    for (Meaning meaning: meaningList) {
	    	meaning.removeWordFromMeaning(word);
	    	if(meaning.getWords().size() == 0) {
	    		meaningRepo.delete(meaning);
	    	}
	    }
	}
}
