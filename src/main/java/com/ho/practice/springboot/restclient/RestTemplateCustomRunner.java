package com.ho.practice.springboot.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

//@Component
public class RestTemplateCustomRunner implements ApplicationRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		String helloResult = restTemplate.getForObject("http://localhost:8080/hello", String.class);
		System.out.println(helloResult);
		
		String worldResult = restTemplate.getForObject("http://localhost:8080/world", String.class);
		System.out.println(worldResult);
		
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
	}
	
	@Bean
	public RestTemplateCustomizer restTemplateCustomizer() {
		return new RestTemplateCustomizer() {
			
			@Override
			public void customize(RestTemplate restTemplate) {
				// 기본적으로 Java에서 제공하는 client를 사용하는데
				// 이를, Apache에서 제공하는 `org.apache.http.client.HttpClient`로 변경할 수 있다.
				restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			}
		};
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

}
