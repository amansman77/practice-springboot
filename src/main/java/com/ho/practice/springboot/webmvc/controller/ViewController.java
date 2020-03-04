package com.ho.practice.springboot.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 동적 템플릿 사용을 위한 엔진 추가 필요 - Tymeleaf 추가
 * @author hosung
 *
 */
@Controller
public class ViewController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "hosung");
		return "hello";
	}
}
