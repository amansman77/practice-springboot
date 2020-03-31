package com.ho.practice.springboot.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/security/**")
			.addResourceLocations("classpath:/templates/security/")
			.setCachePeriod(20);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		WebMvcConfigurer.super.addViewControllers(registry);
		
		registry.addViewController("/hello").setViewName("security/hello");
	}
	
}
