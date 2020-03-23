package com.ho.practice.springboot.data;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ho.practice.springboot.data.redis.Account;
import com.ho.practice.springboot.data.redis.AccountRepository;

@Component
public class RedisRunner implements ApplicationRunner {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("key1", "value1");
		opsForValue.set("key2", "value2");
		opsForValue.set("key3", "value3");
		
		Account account = new Account();
		account.setEmail("hosung@email.com");
		account.setUsername("hosung");
		
		accountRepository.save(account);
		
		Optional<Account> findById = accountRepository.findById(account.getId());
		System.out.println(findById.get().getUsername());
		System.out.println(findById.get().getEmail());
	}

}
