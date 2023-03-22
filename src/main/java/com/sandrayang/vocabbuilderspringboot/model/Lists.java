package com.sandrayang.vocabbuilderspringboot.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Lists {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long listID;
	
	private String listName;
	  
	@ManyToMany
	@JoinTable(name="lists_word", joinColumns = @JoinColumn(name = "listID"), inverseJoinColumns = @JoinColumn(name="wordID"))
	private Set<Word> words = new HashSet<Word>();
	  
	@CreationTimestamp
	private Date createdDate;
	  
	@UpdateTimestamp
	private Date updatedDate;
	
	@ManyToOne
	@JoinColumn(name="creatorID")
//	@NonNull
	private User creator;
	
	public void addWordToList(Word word) {
		this.words.add(word);
	}
	
	public void removeWordFromList(Word word) {
		this.words.remove(word);
	}
	
	public Lists() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lists(String listName, User creator) {
		super();
		this.listName = listName;
		this.creator = creator;
	}

	public long getListID() {
		return listID;
	}

	public void setListID(long listID) {
		this.listID = listID;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Set<Word> getWords() {
		return words;
	}

	public void setWords(Set<Word> words) {
		this.words = words;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	
	
	
}
