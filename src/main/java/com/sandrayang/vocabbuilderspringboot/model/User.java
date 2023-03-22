package com.sandrayang.vocabbuilderspringboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
//	@NonNull
//	@Column(unique=true)
	private String username;
	private String firstName;
	private String lastName;
//	@NonNull
	private String email;
//	@NonNull
	private String Password;
	
	@OneToMany
	@JoinColumn(name="listID")
	private Set<Lists> subscribedList = new HashSet<Lists>();
	
	@OneToMany
	@JoinColumn(name="listID")
	private Set<Lists> createdList = new HashSet<Lists>();
	  
	public void addCreatedList(Lists list) {
		this.createdList.add(list);
	}
	
	public void removeCreatedList(Lists list) {
		this.createdList.remove(list);
	}
	
	public void addSubscribedList(Lists list) {
		this.subscribedList.add(list);
	}
	
	public void removeSubscrtibedList(Lists list) {
		this.subscribedList.remove(list);
	}
	
	// Constructors
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String firstName, String lastName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	// Getters and Setters
	public long getUserID() {
		return userID;
	}
	
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public Set<Lists> getCreatedList() {
		return createdList;
	}
	
	public void setCreatedList(Set<Lists> createdList) {
		this.createdList = createdList;
	}

	public Set<Lists> getSubscribedList() {
		return subscribedList;
	}

	public void setSubscribedList(Set<Lists> subscribedList) {
		this.subscribedList = subscribedList;
	}

	
	
}
