package com.ho.practice.springboot.webmvc.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testGet() throws Exception {
		mockMvc.perform(get("/users"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$._links.self").exists());
	}
	
	@Test
	void testCreate_JSON() throws Exception {
		String userJson = "{\"username\":\"hosung\", \"password\" : \"123\"}";
		mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(userJson))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.username", is(equalTo("hosung"))))
			.andExpect(jsonPath("$.password", is(equalTo("123"))));
	}
	
	@Test
	void testCreate_XML() throws Exception {
		// jackson-dataformat-xml 의존성을 추가하여, XML을 만들수 있는 HttpMessageConverter 추가해야함
		String userJson = "{\"username\":\"hosung\", \"password\" : \"123\"}";
		mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_XML)
				.content(userJson))
			.andExpect(status().isOk())
			.andExpect(xpath("/User/username").string("hosung"))
			.andExpect(xpath("/User/password").string("123"));
	}

}
	