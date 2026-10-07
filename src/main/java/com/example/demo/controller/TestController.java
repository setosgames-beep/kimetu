package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "diagnosis/tester/questions";
	}
	
	@GetMapping("/username")
	public String usernameView() {
	    return "diagnosis/username";
	}
	
	@PostMapping("/questions")
	public String questionsWithUsername(@RequestParam("userName") String userName) {
	    System.out.println("入力されたユーザー名：" + userName);
	    Users user = new Users();
	    user.setUserName(userName);
	    usersService.saveUser(user);
	    return "diagnosis/tester/questions";
	}
	
}
