package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Questions;
import com.example.demo.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {
	
	private final QuestionService questionService;

	// GET /api/questions → 全件取得（表示順）
	@GetMapping
	public List<Questions> getAllQuestions(Model model) {
//		model.addAttribute("questionList", questionService.getAllQuestions());
		return questionService.getAllQuestions();
	}
}