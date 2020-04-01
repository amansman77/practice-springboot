package com.ho.practice.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService /* implements UserDetailsService */ {
	
	@Autowired
	private AccountRepository accountRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
//		account.setPassword(passwordEncoder.encode(password));
		
//		return accountRepository.save(account);
		return null;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Account> findByUsername = accountRepository.findByUsername(username);
//		Account account = findByUsername.orElseThrow(() -> new UsernameNotFoundException(username));
//		return new User(account.getUsername(), account.getPassword(), authorities());
//	}

//	private Collection<? extends GrantedAuthority> authorities() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//	}

}
