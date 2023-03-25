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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;

	@Column(unique=true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	@Pattern(regexp="[a-zA-Z]{2,}", message="Please enter a valid first name")
	private String firstName;
	
	@Column(nullable = false)
	@Pattern(regexp="[a-zA-Z]{2,}", message="Please enter a valid first name")
	private String lastName;
	
	@Column(unique = true, nullable = false)
	@Email(message="Please enter a valid email")
	@Pattern(regexp="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
			, message="Please enter a valid email")
	private String email;

	@NotBlank(message="Please enter a password")
	@Pattern(regexp="[\\S]{8,}", message="The password should be at least 8 characters long, space is not accepted")
	private String password;
	
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

	public User(@Email String email, String username, String firstName, String lastName, String password) {
		super();
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
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
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
