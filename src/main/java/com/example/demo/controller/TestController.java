package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.DiagnosisForm;
import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import com.example.demo.service.impl.TestServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final UsersService usersService;
	private final TestServiceImpl testServiceImpl;

	
	@GetMapping("/test")
	public String testView() {
		return "diagnosis/tester/index";
	}
	
	@GetMapping("/test/character")
	public String testCharacter() {
		return "diagnosis/tester/characters";
	}
	
	@GetMapping("/test/question")
	public String testQuestion() {
		return "diagnosis/tester/question";
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
	public String questionsView(Model model) {
		model.addAttribute("map", testServiceImpl.getQuestionsAndChoices());
		model.addAttribute("diagnosisForm", new DiagnosisForm());
		return "diagnosis/questions";
	}
	
	@GetMapping("/diagnosis/submit")
	public String submit(@ModelAttribute DiagnosisForm form, Model model) {
//		Characters resultCharacter = testServiceImpl.
		
//		model.addAllAttributes("character", resultCharacter);
		return "diagnosis/result";
	}
	
	@GetMapping("/username")
	public String usernameView() {
	    return "diagnosis/username";
	}
	
	@PostMapping("/questions")
	public String questionsWithUsername(@RequestParam("name") String name) {
	    System.out.println("入力されたユーザー名：" + name);
	    Users user = new Users();
	    user.setName(name);
	    usersService.saveUser(user);
	    return "diagnosis/tester/questions";
	}
	
}
