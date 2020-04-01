package com.ho.practice.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

	@Autowired
	private AccountService accountService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account createAccount = accountService.createAccount("hosung", "1234");
		System.out.println(createAccount.getUsername() + " password: " + createAccount.getPassword());
	}

}
