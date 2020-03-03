package com.ho.practice.springboot.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeWebMvcSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PracticeWebMvcSpringbootApplication.class);
		app.run(args);
	}

}
