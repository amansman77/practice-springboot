package com.ho.practice.springboot.data;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.ho.practice.springboot.data.mongo.Account;
import com.ho.practice.springboot.data.mongo.AccountMongoRepository;

//@Component
public class MongoRunner implements ApplicationRunner {
	
//	@Autowired
//	private MongoTemplate mongoTemplate;
	
	@Autowired
	private AccountMongoRepository accountRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account account = new Account();
		account.setEmail("hosung@email.com");
		account.setUsername("hosung");
		
//		mongoTemplate.insert(account);
		
		List<Account> accounts = accountRepository.findByEmail(account.getEmail());
		System.out.println(accounts.size());
		System.out.println(accounts.get(0).getUsername());
		System.out.println(accounts.get(0).getEmail());
	}
	
}
