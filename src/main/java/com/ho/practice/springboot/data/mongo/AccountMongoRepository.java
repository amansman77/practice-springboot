package com.ho.practice.springboot.data.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountMongoRepository  extends MongoRepository<Account, String> {

	List<Account> findByEmail(String email);
	
}
