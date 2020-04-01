package com.ho.practice.springboot.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class WebClientRunner implements ApplicationRunner {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		WebClient webClient = webClientBuilder.build();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Mono<String> helloMono = webClient.get().uri("http://localhost:8080/hello")
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
		
		Mono<String> worldMono = webClient.get().uri("http://localhost:8080/world")
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

}
