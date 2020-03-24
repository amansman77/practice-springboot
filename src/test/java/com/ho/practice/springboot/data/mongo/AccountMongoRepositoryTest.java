package com.ho.practice.springboot.data.mongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
class AccountMongoRepositoryTest {

	@Autowired
	private AccountMongoRepository accountRepository;
	
	@Test
	void testFindByEmail() {
		Account account = new Account();
		account.setEmail("hosung@email.com");
		account.setUsername("hosung");
		accountRepository.insert(account);
		
		Optional<Account> findById = accountRepository.findById(account.getId());
		assertNotNull(findById.get());
		assertEquals("hosung", findById.get().getUsername());
		
		List<Account> accounts = accountRepository.findByEmail(account.getEmail());
		assertEquals(1, accounts.size());
	}

}
