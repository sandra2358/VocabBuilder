package com.sandrayang.vocabbuilderspringboot.service;

import java.util.List;
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
		word.addListToWord(list);
	};
	  
	
	  
	public List<Meaning> findMeanings(long wordID){
		Optional<Word> wordOptional= wordRepo.findWordByWordID(wordID);
		Word word = wordOptional.get();
		return word.getMeanings();
	}
	
	public boolean isSameWord(Word oldWord, Word newWord) {
		if (oldWord.equals(newWord)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Word updateWord (Word oldWord, Word newWord, Lists list) {
		if (oldWord.getList().size() == 1) {
			oldWord.setArticle(newWord.getArticle());
			oldWord.setPartOfSpeech(newWord.getPartOfSpeech());
			oldWord.setMeanings(newWord.getMeanings());
			oldWord.setWord(newWord.getWord());
			wordRepo.save(oldWord);
		} else if (oldWord.getList().size() > 1) {
			oldWord.removeListFromWord(list);
			wordRepo.save(newWord);
			addWord(newWord,list);
		}
		return oldWord;
		
	}
}
