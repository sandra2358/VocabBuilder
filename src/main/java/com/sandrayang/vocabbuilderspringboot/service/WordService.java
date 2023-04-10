package com.sandrayang.vocabbuilderspringboot.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
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
		Optional<Lists> oldListOptional = listsRepo.findByListID(list.getListID());
		wordRepo.save(word);
		Lists oldList = oldListOptional.get();
		try {
			
			Set<Word> oldWords = oldList.getWords();
			oldWords.add(word);
			oldList.setWords(oldWords);
			listsRepo.save(oldList);
		} catch(NoSuchElementException noe) {
			System.out.println("Cannot find list");
//		} catch(SQLException sqle) {
//			Throwable cause = sqle.getCause();
//			if (cause instanceof SQLIntegrityConstraintViolationException) {
//				System.out.println("sql problem");
//			}
//			throw sqle;
		}catch(Exception e) {
			System.out.println("failed to save word" + word.getWordID() +word.getWord() + "to list" + list.getListID()+ list.getListName());
		}
		
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
		Optional<Word> wordOptional = wordRepo.findById(oldWord.getWordID());
		try {
			Word word = wordOptional.get();
			word.setArticle(newWord.getArticle());
			word.setPartOfSpeech(newWord.getPartOfSpeech());
			word.setMeanings(newWord.getMeanings());
			word.setWord(newWord.getWord());
			wordRepo.save(oldWord);
		} catch(Exception e) {
			
		}
		
		return oldWord;
		
	}
}
