package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Characters;
import com.example.demo.entity.Choices;
import com.example.demo.entity.Questions;

public interface TestService {
	List<Characters> getAllCharacters();
	Characters getCharacterById(int id);
	
	Map<Questions, List<Choices>> getQuestionsAndChoices();
	List<Choices> getChoices(int questionId);
	
	Characters calculateResult(List<Integer> selectedChoiceIds);
}
