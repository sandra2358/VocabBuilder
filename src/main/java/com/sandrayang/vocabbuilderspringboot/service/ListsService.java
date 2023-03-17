package com.sandrayang.vocabbuilderspringboot.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.Meaning;
import com.sandrayang.vocabbuilderspringboot.model.User;
import com.sandrayang.vocabbuilderspringboot.model.Word;
import com.sandrayang.vocabbuilderspringboot.repositories.ListsRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.MeaningRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.WordRepo;

@Service
public class ListsService {
	
	@Autowired 
	ListsRepo listsRepo;
	@Autowired @Lazy
	UserService userService;
	@Autowired
	WordRepo wordRepo;
	@Autowired
	MeaningRepo meaningRepo;
	
	public Optional<Lists> findByListID(long listID){
		return listsRepo.findByListID(listID);
	};
	
	
	  
	public void addList(Lists list){
		listsRepo.save(list);
		User creator = list.getCreator();
	    userService.addListToCreatedList(list, creator);
	}


	public Set<Word> findWords(Lists list){
		return list.getWords();
	}
	
	  
	public long findNumWords(Lists list){
		return list.getWords().size();
	}
	
	  
	public void addWordToList(Word word, Lists list){
		Set<Word> wordList = list.getWords();
	    wordList.add(word);
	    list.setWords(wordList);
    }
	  
	// delete word if the word doesn't exist in other lists
	public void deleteWordFromList(Word word,Lists list){
		Set<Word> wordList = list.getWords();
	    wordList.remove(word);
	    list.setWords(wordList);
	    // list.setWord(list.getWords.remove(word));
	    Set<Lists> lists = word.getList();
	    lists.remove(list);
	    word.setList(lists);
	    if (word.getList().size() == 0) {
	    	Set<Meaning> wordMeanings = word.getMeanings();
	    	// delete the meanings of the word
//	    	wordMeanings.stream();//.forEach(x -> meaningRepo.delete(x));
//	    	wordRepo.delete(word); 
	    }
	}
}
