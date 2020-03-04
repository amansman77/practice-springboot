package com.ho.practice.springboot.webmvc.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ho.practice.springboot.webmvc.controller.UserSpringController;

@WebMvcTest(value = UserSpringController.class)
class UserSpringControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testCreate() throws Exception {
		String userJson = "{\"username\":\"hosung\", \"password\" : \"123\"}";
		mockMvc.perform(post("/spring/users")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(userJson))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.username", is(equalTo("hosung"))))
			.andExpect(jsonPath("$.password", is(equalTo("123"))));
	}

}
