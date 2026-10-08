package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Choices;
import com.example.demo.entity.Diagnosis_results;
import com.example.demo.entity.Questions;
import com.example.demo.repository.ChoiceMapper;
import com.example.demo.repository.DiagnosisResultsMapper;
import com.example.demo.repository.QuestionMapper;
import com.example.demo.service.DiagnosisService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {
	
	private final QuestionMapper questionMapper;
	
	private final ChoiceMapper choiceMapper;
	
	private final DiagnosisResultsMapper resultMapper;

	@Override
	public int diagnose(List<Integer> choiceIds) {

		if (choiceIds == null || choiceIds.isEmpty()) {
			throw new IllegalArgumentException("回答がありません");
		}

		// 選択肢ID → キャラクターID の対応表
		Map<Integer, Integer> choiceToCharacter = new HashMap<>();
		for (Questions question : questionMapper.findAll()) {
			int questionId = Math.toIntExact(question.getId());
			for (Choices choice : choiceMapper.findByQuestionId(questionId)) {
				choiceToCharacter.put(
						Math.toIntExact(choice.getId()),
						Math.toIntExact(choice.getCharacterId()));
			}
		}

		// キャラクターIDごとに1点ずつ加算（TreeMap：IDの小さい順）
		Map<Integer, Integer> scores = new TreeMap<>();
		for (int choiceId : choiceIds) {
			Integer characterId = choiceToCharacter.get(choiceId);
			if (characterId == null) {
				throw new IllegalArgumentException("存在しない選択肢です：" + choiceId);
			}
			scores.put(characterId, scores.getOrDefault(characterId, 0) + 1);
		}

		// 最高点のキャラクター（同点なら小さいID）
		int resultId = 0;
		int maxScore = 0;
		for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
			if (entry.getValue() > maxScore) {
				maxScore = entry.getValue();
				resultId = entry.getKey();
			}
		}
		return resultId;
	}

	@Override
	public void insert(Diagnosis_results result) {
		resultMapper.insert(result);
	}

	@Override
	public List<Diagnosis_results> findByUserId(int userId) {
		return resultMapper.findByUserIdOrderByDiagnosedAtDesc(userId);
	}
}