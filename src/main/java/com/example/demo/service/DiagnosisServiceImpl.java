package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Diagnosis_results;
import com.example.demo.repository.ChoiceCharacterScoreMapper;
import com.example.demo.repository.DiagnosisResultMapper;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private ChoiceCharacterScoreMapper scoreMapper;

	@Autowired
	private DiagnosisResultMapper resultMapper;

	// ===== 診断ロジック =====
	@Override
	public int diagnose(List<Integer> choiceIds) {

		// 回答がない場合はエラーにする
		if (choiceIds == null || choiceIds.isEmpty()) {
			throw new IllegalArgumentException("回答がありません");
		}

		// キャラクターIDごとのスコア合算
		// TreeMapはキー（キャラクターID）が小さい順に並ぶ
		Map<Integer, Integer> scores = new TreeMap<>();

		// 各choiceIdについて、対応するキャラクター＆スコアを取得
		for (int choiceId : choiceIds) {
			// choice_character_scores テーブルから
			// この選択肢に紐づくキャラクターとスコアを取得
			// 例：choiceId=5 → キャラ1に+2点、キャラ2に+1点...
			// ※ scoreMapper.findByChoiceId(choiceId) を実装後に可能
		}

		// 一番高いスコアのキャラクターを探す
		// 小さいIDから順に見て「より大きい」ときだけ更新するので、
		// 同点なら小さいIDのキャラクターが残る
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

	// ===== 結果CRUD（Repositoryができてから作る） =====
	@Override
	public void insert(Diagnosis_results result) {
		resultMapper.insert(result);
	}

	@Override
	public List<Diagnosis_results> findAll() {
		return resultMapper.findAll();
	}

	@Override
	public Diagnosis_results findById(Long id) {
		return resultMapper.findById(id);
	}
}