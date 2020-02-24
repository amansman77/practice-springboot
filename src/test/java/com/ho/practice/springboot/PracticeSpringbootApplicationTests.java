package com.ho.practice.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class PracticeSpringbootApplicationTests {

	@Autowired
	Environment envirinment;
	
	@Test
	void contextLoads() {
		assertEquals("test-hosung", envirinment.getProperty("sample.name"));
	}
	
}
