package com.sandrayang.vocabbuilderspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Antonym {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long antonymID;
	
	// should be list
	private String antonym; 
}
