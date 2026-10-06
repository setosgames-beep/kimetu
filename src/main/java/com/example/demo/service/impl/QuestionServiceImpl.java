package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Questions;
import com.example.demo.repository.QuestionMapper;
import com.example.demo.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
	
	private final QuestionMapper questionMapper;

	@Override
	public List<Questions> getAllQuestions() {
		return questionMapper.findAll();
	}
}
