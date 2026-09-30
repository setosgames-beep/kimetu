package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Questions;

import service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	// GET /api/questions → 全件取得（表示順でソート済み）
	@GetMapping
	public List<Questions> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	// GET /api/questions/{id} → 1件取得
	@GetMapping("/{id}")
	public Questions getQuestionById(@PathVariable int id) {
		return questionService.getQuestionById(id);
	}
	
	// POST /api/questions → 新規登録
	@PostMapping
	public void createQuestion(@RequestBody Questions question) {
		questionService.saveQuestion(question);
	}
}