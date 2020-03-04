package com.ho.practice.springboot.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ho.practice.springboot.webmvc.User;

@Controller
public class UserSpringController {
	
	@PostMapping("/spring/users")
	public @ResponseBody User create(@RequestBody User user) {
		return user;
	}
}
