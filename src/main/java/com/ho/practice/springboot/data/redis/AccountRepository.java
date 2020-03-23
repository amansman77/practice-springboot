package com.ho.practice.springboot.data.redis;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
