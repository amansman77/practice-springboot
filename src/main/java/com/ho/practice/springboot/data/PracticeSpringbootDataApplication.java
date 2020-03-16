package com.ho.practice.springboot.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeSpringbootDataApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PracticeSpringbootDataApplication.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.run(args);
	}

}
