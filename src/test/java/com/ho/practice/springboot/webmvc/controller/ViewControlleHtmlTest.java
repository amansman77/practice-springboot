package com.ho.practice.springboot.webmvc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@WebMvcTest(value = ViewController.class)
class ViewControlleHtmlTest {

	@Autowired
	WebClient webClient;
	
	@Test
	void testHelloView() throws Exception {
		HtmlPage page = webClient.getPage("/hello");
		HtmlHeading1 h1 = page.getFirstByXPath("//h1");
		assertEquals("hosung", h1.getTextContent());
	}

}
