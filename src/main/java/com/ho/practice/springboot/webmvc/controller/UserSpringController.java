package com.ho.practice.springboot.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ho.practice.springboot.webmvc.AppError;
import com.ho.practice.springboot.webmvc.User;
import com.ho.practice.springboot.webmvc.UserException;

@Controller
public class UserSpringController {
	
	@PostMapping("/spring/users")
	public @ResponseBody User create(@RequestBody User user) {
		return user;
	}
	
	@GetMapping("/spring/exception")
	public String exception() {
		throw new UserException();
	}
	
	@ExceptionHandler(UserException.class)
	public @ResponseBody AppError appError(UserException userException) {
		AppError appError = new AppError();
		appError.setMessage("App error");
		appError.setReason("IDK IDK IDK");
		return appError;
	}
}
