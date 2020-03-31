package com.ho.practice.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeSecurityApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PracticeSecurityApplication.class);
		app.run(args);
	}

}
