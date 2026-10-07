package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Characters;
import com.example.demo.entity.Choices;
import com.example.demo.entity.Questions;
import com.example.demo.repository.CharacterMapper;
import com.example.demo.repository.ChoiceMapper;
import com.example.demo.repository.QuestionMapper;
import com.example.demo.service.TestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
	
	private final CharacterMapper characterMapper;
	private final QuestionMapper questionMapper;
	private final ChoiceMapper choiceMapper;
	
	@Override
	public List<Characters> getAllCharacters() {
		return characterMapper.findAll();
	}
	
	@Override
	public Characters getCharacterById(int id) {
		return characterMapper.findById(id);
	}
	
	@Override
	public Map<Questions, List<Choices>> getQuestionsAndChoices() {
		Map<Questions, List<Choices>> qcMap = new HashMap<>();
		for (Questions question : questionMapper.findAll()) {
			qcMap.put(question, getChoices(question.getId()));
		}
		return qcMap;
	}
	
	@Override
	public List<Choices> getChoices(int questionId) {
		return choiceMapper.findByQuestionId(questionId);
	}
	
	@Override
	public Characters calculateResult(List<Integer> selectedChoiceIds) {
		if (selectedChoiceIds == null || selectedChoiceIds.isEmpty()) {
			return null;
		}
		
		 Map<Integer, Integer> scoreMap = new HashMap<>();

	        // 選択された選択肢を確認
		 for (Integer choiceId : selectedChoiceIds) {

			    if (choiceId == null) {
			        continue;
			    }

			    Choices choice = choiceMapper.findById(choiceId);

			    if (choice != null) {

			        int characterId = choice.getCharacterId();

			        scoreMap.put(
			            characterId,
			            scoreMap.getOrDefault(characterId, 0) + 1
			        );
	            }
	        }

	        // 有効な選択肢がなかった場合
	        if (scoreMap.isEmpty()) {
	            return null;
	        }

	        // 最も得票数が多いキャラクターIDを取得
	        int resultCharacterId = -1;
	        int maxScore = -1;

	        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {

	            if (entry.getValue() > maxScore) {
	                resultCharacterId = entry.getKey();
	                maxScore = entry.getValue();
	            }
	        }

	        // キャラクターIDから診断結果を取得
	        return characterMapper.findById(resultCharacterId);
	    }
}
