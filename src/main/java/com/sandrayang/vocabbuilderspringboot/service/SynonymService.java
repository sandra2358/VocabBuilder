package com.sandrayang.vocabbuilderspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.repositories.SynonymRepo;

@Service
public class SynonymService {
	
	@Autowired
	SynonymRepo synonymRepo;
	

}
