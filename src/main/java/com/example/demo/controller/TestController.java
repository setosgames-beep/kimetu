package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;

@Controller
public class TestController {
	
	@Autowired
	private UsersService usersService;
	
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
	
	@GetMapping("/username")
	public String usernameView() {
	    return "diagnosis/username";
	}
	
	@PostMapping("/questions")
	public String questionsWithUsername(@RequestParam("username") String username) {
	    System.out.println("入力されたユーザー名：" + username);
	    Users user = new Users();
	    user.setUsername(username);
	    usersService.saveUser(user);
	    return "diagnosis/questions";
	}
	
}
