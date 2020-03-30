package com.ho.practice.springboot.data.mongo;

import java.util.List;

public interface AccountMongoRepository /* extends MongoRepository<Account, String> */ {

	List<Account> findByEmail(String email);
	
}
