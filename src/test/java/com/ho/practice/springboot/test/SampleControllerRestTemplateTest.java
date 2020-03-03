package com.ho.practice.springboot.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleControllerRestTemplateTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@MockBean
	private SampleService sampleService;
	
	@Test
	void testHello() throws Exception {
		when(sampleService.getName()).thenReturn("test");
		
		String result = testRestTemplate.getForObject("/hello", String.class);
		assertEquals("hello test", result);
	}

}
