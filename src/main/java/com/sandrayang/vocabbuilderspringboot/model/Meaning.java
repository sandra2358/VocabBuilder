package com.sandrayang.vocabbuilderspringboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Meaning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long meaningID;
	  
	private String meaning;
	@ManyToMany(mappedBy="meanings")
	private Set<Word> words = new HashSet<Word>();

	public Meaning() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meaning(String meaning) {
		super();
		this.meaning = meaning;
	}

	public long getMeaningID() {
		return meaningID;
	}

	public void setMeaningID(long meaningID) {
		this.meaningID = meaningID;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Set<Word> getWords() {
		return words;
	}

	public void setWords(Set<Word> words) {
		this.words = words;
	}
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long meaningID;
//	
//	private String meaning;

	
}
