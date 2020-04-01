package com.ho.practice.springboot.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class ViewControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
//	@WithMockUser
	void testHello() throws Exception {
		mockMvc.perform(get("/hello")
				.accept(MediaType.TEXT_HTML))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("security/hello"));
	}
	
	@Test
//	@WithMockUser
	void testMy() throws Exception {
		mockMvc.perform(get("/my"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("security/my"));
	}

}
