package com.ho.practice.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

//	@Value("${sample.name}")
//	private String name;
	
	@Autowired
	SampleProperties sampleProperties;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("==============================");
		System.out.println(sampleProperties.getName());
		System.out.println(sampleProperties.getAge());
		System.out.println("==============================");
	}

}
