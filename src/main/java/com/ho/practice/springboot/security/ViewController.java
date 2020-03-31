package com.ho.practice.springboot.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	// /hello는 WebConfig.java에 정의함
	
	@GetMapping("/my")
	public String my() {
		return "security/my";
	}
	
}
