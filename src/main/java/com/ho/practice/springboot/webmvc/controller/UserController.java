package com.ho.practice.springboot.webmvc.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ho.practice.springboot.webmvc.User;

@RestController
public class UserController {
	
	@GetMapping("/users")
	public EntityModel<User> getUsers() {
		User user = new User();
		user.setUsername("hosung");
		user.setPassword("123");
		
		EntityModel<User> userModel = new EntityModel<>(user);
		
//		@Deprecated
//		import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
//		import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;
//		userModel.add(linkTo(methodOn(UserController.class).getUsers()).withSelfRel());
		
//		Using Link
		userModel.add(new Link("/users"));
		
		return userModel;
	}
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return user;
	}
}
