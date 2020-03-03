package com.ho.practice.springboot.webmvc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return user;
	}
}
