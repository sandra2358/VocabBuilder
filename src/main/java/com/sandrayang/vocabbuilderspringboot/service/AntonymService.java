package com.sandrayang.vocabbuilderspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.repositories.AntonymRepo;

@Service
public class AntonymService {
	
	@Autowired
	AntonymRepo antonymRepo;
}
