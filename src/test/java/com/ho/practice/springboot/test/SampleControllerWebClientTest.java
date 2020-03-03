package com.ho.practice.springboot.test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleControllerWebClientTest {

	// webflux 디펜던시 추가 후 사용
	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private SampleService sampleService;
	
	@Test
	void testHello() throws Exception {
		when(sampleService.getName()).thenReturn("test");
		
		webTestClient.get().uri("/hello").exchange()
			.expectStatus().isOk()
			.expectBody(String.class).isEqualTo("hello test");
	}

}
