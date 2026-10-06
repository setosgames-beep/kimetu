package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.impl.TestServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final TestServiceImpl testServiceImpl;
	
	@GetMapping("/test")
	public String testView() {
		return "test/test";
	}
	
	@GetMapping("/")
	public String diagnosisView(Model model) {
		model.addAttribute("testCharacter", testServiceImpl.getCharacterById(3));
		return "diagnosis/index";
	}
	
	@GetMapping("/characters")
	public String charactersView(Model model) {
		model.addAttribute("characterList", testServiceImpl.getAllCharacters());
		return "diagnosis/characters";
	}
	
	@GetMapping("/questions")
	public String questionsView() {
		return "diagnosis/questions";
	}
	
}
