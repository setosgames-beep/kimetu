package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Choices;
import com.example.demo.entity.Diagnosis_results;
import com.example.demo.entity.Questions;
import com.example.demo.repository.ChoiceMapper;
import com.example.demo.repository.DiagnosisResultsMapper;
import com.example.demo.repository.QuestionMapper;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	private ChoiceMapper choiceMapper;

	@Autowired
	private DiagnosisResultsMapper resultMapper;

	@Override
	public int diagnose(List<Integer> choiceIds) {

		if (choiceIds == null || choiceIds.isEmpty()) {
			throw new IllegalArgumentException("回答がありません");
		}

		// 選択肢ID → キャラクターID の対応表
		Map<Integer, Integer> choiceToCharacter = new HashMap<>();
		for (Questions question : questionMapper.findAllOrderByDisplayOrder()) {
			for (Choices choice : choiceMapper.findByQuestionId(question.getId())) {
				choiceToCharacter.put(choice.getId(), choice.getCharacter_id());
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
