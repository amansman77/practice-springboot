package com.ho.practice.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeTestSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PracticeTestSpringbootApplication.class);
		app.run(args);
	}

}
