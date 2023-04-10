package com.sandrayang.vocabbuilderspringboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.service.ListsService;

@RestController
public class ListsController {
	
	@Autowired
	private ListsService listsService;
	
	@GetMapping("/list/{listID}")
	public ResponseEntity<Lists> getList(@PathVariable("listID") long listID){
		Optional<Lists> list = listsService.findByListID(listID);
		try {
			return ResponseEntity.ok().body(list.get());
		} catch (Exception e){
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
	}

}
