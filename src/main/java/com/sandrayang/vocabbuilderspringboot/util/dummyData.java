package com.sandrayang.vocabbuilderspringboot.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.sandrayang.vocabbuilderspringboot.model.Lists;
import com.sandrayang.vocabbuilderspringboot.model.Meaning;
import com.sandrayang.vocabbuilderspringboot.model.PartOfSpeech;
import com.sandrayang.vocabbuilderspringboot.model.User;
import com.sandrayang.vocabbuilderspringboot.model.Word;
import com.sandrayang.vocabbuilderspringboot.repositories.ListsRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.UserRepo;
import com.sandrayang.vocabbuilderspringboot.repositories.WordRepo;
import com.sandrayang.vocabbuilderspringboot.service.ListsService;
import com.sandrayang.vocabbuilderspringboot.service.MeaningService;
import com.sandrayang.vocabbuilderspringboot.service.UserService;
import com.sandrayang.vocabbuilderspringboot.service.WordService;


@Service
public class dummyData implements CommandLineRunner{
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ListsRepo listsRepo;
	@Autowired
	private WordRepo wordRepo;
	@Autowired
    UserService userService;
    @Autowired
    ListsService listsService;
    @Autowired
    WordService wordService;
    @Autowired
    MeaningService meaningService;
	
	@Override
	public void run(String... args) throws Exception {
	    
	    
	    User user1 = new User("Sandra2358","Sandra","Yang");
	    Lists list1 = new Lists("B1",user1);
	    Word word1 = new Word("die","Schokolade");
	    Word word2 = new Word("laufen");
	    Word word3 = new Word("duschen",PartOfSpeech.Verb);
	    Meaning meaning1 = new Meaning("susses Nachtisch aus Kako");
	    
	    userService.addUser(user1);
	    listsService.addList(list1);
	    wordService.addWord(word1,list1);
	    wordService.addWord(word2,list1);
	    wordService.addWord(word3,list1);
	    meaningService.addMeaning(meaning1,word1);
	    listsService.deleteWordFromList(word3,list1);
		
	}

}
