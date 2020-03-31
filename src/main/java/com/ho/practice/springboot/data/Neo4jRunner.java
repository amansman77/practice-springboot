package com.ho.practice.springboot.data;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.ho.practice.springboot.data.neo4j.Account;
import com.ho.practice.springboot.data.neo4j.AccountNeo4jRepository;
import com.ho.practice.springboot.data.neo4j.Role;

//@Component
public class Neo4jRunner implements ApplicationRunner {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Autowired
	private AccountNeo4jRepository accountRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role role = new Role();
		role.setName("admin");
		
		Account account = new Account();
		account.setEmail("hosung@email.com");
		account.setUsername("hosung");
		account.getRoles().add(role);
		
//		Session session = sessionFactory.openSession();
//		session.save(account);
//		session.clear();
//		sessionFactory.close();
		
		Account account2 = new Account();
		account2.setEmail("user2@email.com");
		account2.setUsername("user2");
		account2.getRoles().add(role);
		
//		accountRepository.save(account);
//		accountRepository.save(account2);
		
		List<Account> findByUsername = accountRepository.findByUsername("user2");
		
		System.out.println(findByUsername.size());
		System.out.println(findByUsername.get(0).getUsername());
		System.out.println(findByUsername.get(0).getEmail());
	}
	
}
