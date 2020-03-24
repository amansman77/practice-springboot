package com.ho.practice.springboot.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.ho.practice.springboot.data.redis.Account;
import com.ho.practice.springboot.data.redis.AccountRepository;

//@Component
public class RedisRunner implements ApplicationRunner {
	
//	@Autowired
//	private StringRedisTemplate redisTemplate;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//		opsForValue.set("key1", "value1");
//		opsForValue.set("key2", "value2");
//		opsForValue.set("key3", "value3");
		
		Account account = new Account();
		account.setEmail("hosung@email.com");
		account.setUsername("hosung");
		
//		accountRepository.save(account);
		
//		Optional<Account> findById = accountRepository.findById(account.getId());
//		System.out.println(findById.get().getUsername());
//		System.out.println(findById.get().getEmail());
	}

}
