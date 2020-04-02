package com.ho.practice.springboot.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import reactor.core.publisher.Mono;

//@Component
public class WebClientCustomRunner implements ApplicationRunner {

	@Autowired
	private WebClient webClient;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Mono<String> helloMono = webClient.get().uri("/hello")
				.retrieve()
				.bodyToMono(String.class);
		helloMono.subscribe(s -> {
			System.out.println(s);
			
			if (stopWatch.isRunning()) {
				stopWatch.stop();
			}
			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});
		
		Mono<String> worldMono = webClient.get().uri("/world")
				.retrieve()
				.bodyToMono(String.class);
		worldMono.subscribe(s -> {
			System.out.println(s);
			
			if (stopWatch.isRunning()) {
				stopWatch.stop();
			}
			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});
	}
	
	@Bean
	public WebClientCustomizer webClientCustomizer() {
		return new WebClientCustomizer() {
			
			@Override
			public void customize(Builder webClientBuilder) {
				webClientBuilder.baseUrl("http://localhost:8080");
			}
		};
	}
	
	@Bean
	public WebClient webClient(Builder webClientBuilder) {
		return webClientBuilder.build();
	}

}
