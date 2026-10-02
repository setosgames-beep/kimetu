package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Questions;
import com.example.demo.repository.QuestionMapper;
import com.example.demo.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Override
	public List<Questions> getAllQuestions() {
		return questionMapper.findAllOrderByDisplayOrder();
	}
	
	@Override
	public Questions getQuestionById(int id) {
		return questionMapper.findById(id);
	}
	
	@Override
	public void saveQuestion(Questions question) {
		questionMapper.save(question);
	}
}

