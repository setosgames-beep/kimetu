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
	
	// →CharactersService
	@Override
	public List<Characters> getAllCharacters() {
		return characterMapper.findAll();
	}
	
	@Override
	public Characters getCharacterById(int id) {
		return characterMapper.findById(id);
	}
	
	// →QuestionsService
	@Override
	public Map<Questions, List<Choices>> getQuestionsAndChoices() {
		Map<Questions, List<Choices>> qcMap = new HashMap<>();
		for (Questions question : questionMapper.findAll()) {
			qcMap.put(question, getChoices(question.getId()));
		}
		return qcMap;
	}
	
	// →QuestionsService　（ChoicesをQuestionsに統合）
	@Override
	public List<Choices> getChoices(int questionId) {
		return choiceMapper.findByQuestionId(questionId);
	}
	
	// →DiagnosisService
	@Override
	public Characters calculateResult(Map<Integer, Integer> selects) {
		if (selects == null || selects.isEmpty()) {
			return null;
		}
		

		// キャラクターIDとその獲得ポイントを記録するマップ
		// Key: characters_id, Value: 獲得ポイント
		Map<Integer, Integer> scoreMap = new HashMap<>();
		
		// 1.選ばれた選択肢ごとにキャラクターのポイントを集計
		for (Integer choiceId : selects.values()) {
			Choices choice = choiceMapper.findById(choiceId);
			
			if (choice != null && choice.getCharacterId() != null) {
				Integer characterId = choice.getCharacterId();
				
				scoreMap.put(characterId, scoreMap.getOrDefault(characterId, 0) + 1);
			}
		}
		
		// 2.最もポイントが高いキャラクターIDを見つける
		Integer bestCharacterId = null;
		int maxSchore = -1;
		
		for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
			if (entry.getValue() > maxSchore) {
				maxSchore = entry.getValue();
				bestCharacterId = entry.getKey();
			}
		}
		
		// 3.最多得点のキャラクターの情報をDBから取得、して返す
		if (bestCharacterId != null) {
			Characters testchar = characterMapper.findById(bestCharacterId);
			if (testchar == null) {
				System.out.println("ヌルヌルヌルヌル");
			}
			System.out.println(testchar.getFirstName());
			return characterMapper.findById(bestCharacterId);
		}
		
		return null;
	}
}
