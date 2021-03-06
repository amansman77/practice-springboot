package com.ho.practice.springboot.security;

import java.util.Optional;

public interface AccountRepository /* extends JpaRepository<Account, Long> */ {

	Optional<Account> findByUsername(String username);
}
