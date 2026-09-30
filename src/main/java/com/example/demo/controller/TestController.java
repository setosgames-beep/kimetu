package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test")
	public String testView() {
		return "test/test";
	}
	
	@GetMapping("/")
	public String diagnosisView() {
		return "diagnosis/index";
	}
	
	@GetMapping("/characters")
	public String charactersView() {
		return "diagnosis/characters";
	}
	
	@GetMapping("/questions")
	public String questionsView() {
		return "diagnosis/questions";
	}
	
}
