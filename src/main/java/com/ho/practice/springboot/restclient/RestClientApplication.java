package com.ho.practice.springboot.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestClientApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RestClientApplication.class);
		app.run(args);
	}

}
