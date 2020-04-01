package com.ho.practice.springboot.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig /* extends WebSecurityConfigurerAdapter */ {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//			.antMatchers("/security/index.html", "/hello").permitAll()
//			.anyRequest().authenticated()
//			.and()
//		.formLogin()
//			.and()
//		.httpBasic();
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
}
