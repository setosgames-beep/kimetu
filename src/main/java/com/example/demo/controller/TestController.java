package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Characters;
import com.example.demo.entity.Users;
import com.example.demo.form.DiagnosisForm;
import com.example.demo.service.TestService;
import com.example.demo.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final UsersService usersService;
	private final TestService testService;

	
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
		model.addAttribute("testCharacter", testService.getCharacterById(3));
		return "diagnosis/index";
	}
	
	@GetMapping("/characters")
	public String charactersView(Model model) {
		model.addAttribute("characterList", testService.getAllCharacters());
		return "diagnosis/characters";
	}
	
	@GetMapping("/questions")
	public String questionsView(@ModelAttribute DiagnosisForm form, Model model) {
		model.addAttribute("map", testService.getQuestionsAndChoices());
//		model.addAttribute("diagnosisForm", new DiagnosisForm());
		return "diagnosis/questions";
	}
	
	@PostMapping("/diagnosis/submit")
	public String submit(@ModelAttribute DiagnosisForm form, Model model) {
		
		// 1.htmlでrequiredの最終確認(全部選択したかどうかの確認）
		int totalQuestions = testService.getQuestionsAndChoices().size();
		int answeredQuestions = form.getSelects().size();
		
		if (answeredQuestions < totalQuestions) {
			// 1.質問と選択肢のマップを再セット
			model.addAttribute("map", testService.getQuestionsAndChoices());
			// 2.ユーザーが選択したデータが入っているformを返す
			model.addAttribute("diagnosisForm", form);
			model.addAttribute("error", "すべての質問に回答してください。");
			return "diagnosis/questions";
		}
		
		// 2.フォームの値を受け取て集計にまわす
		Characters resultCharacter = testService.calculateResult(form.getSelects());
		
		// 3.集計結果を受け取り、結果画面にまわす
		model.addAttribute("character", resultCharacter);
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
