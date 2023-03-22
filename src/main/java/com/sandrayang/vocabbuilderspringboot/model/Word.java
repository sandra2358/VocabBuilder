package com.sandrayang.vocabbuilderspringboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Word {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wordID;
	  
	@ManyToMany(mappedBy="words")
	private Set<Lists> list = new HashSet<Lists>();
	  
	@ManyToMany
	@JoinTable(name="word_meaning", joinColumns = @JoinColumn(name = "wordID"), inverseJoinColumns = @JoinColumn(name="meaningID"))
	private Set<Meaning> meanings = new HashSet<Meaning>();
	
	private String article; 
	private String word;
	
	@Enumerated(EnumType.STRING)
	private PartOfSpeech partOfSpeech;

	
	public void addMeaningToWord(Meaning meaning) {
		this.meanings.add(meaning);
	}
	
	public void removeMeaningFromWord(Meaning meaning) {
		this.meanings.remove(meaning);
	}
	
	
	// Constructors
	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Word(String article, String word){
		this.article = article;
		this.word = word;
	}
	  
	public Word(String word){
	  this.word = word;
	}
	  
	public Word(String word,PartOfSpeech partOfSpeech){
		this.word = word;
	    this.partOfSpeech = partOfSpeech;
	}

	
	// Getters and Setters
	public long getWordID() {
		return wordID;
	}

	public void setWordID(long wordID) {
		this.wordID = wordID;
	}

	public Set<Lists> getList() {
		return list;
	}

	public void setList(Set<Lists> list) {
		this.list = list;
	}

	public Set<Meaning> getMeanings() {
		return meanings;
	}

	public void setMeanings(Set<Meaning> meanings) {
		this.meanings = meanings;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public PartOfSpeech getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}
	
	
	
}
