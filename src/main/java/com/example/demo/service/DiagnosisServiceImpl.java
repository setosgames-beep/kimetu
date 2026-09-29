package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	// ===== 診断ロジック =====
	@Override
	public int diagnose(List<Integer> characterIds) {

		// 回答がない場合はエラーにする
		if (characterIds == null || characterIds.isEmpty()) {
			throw new IllegalArgumentException("回答がありません");
		}

		// キャラクターIDごとの出現回数を数える
		// TreeMapはキー（キャラクターID）が小さい順に並ぶ
		Map<Integer, Integer> counts = new TreeMap<>();
		for (int id : characterIds) {
			counts.put(id, counts.getOrDefault(id, 0) + 1);
		}

		// 一番多いキャラクターを探す
		// 小さいIDから順に見て「より大きい」ときだけ更新するので、
		// 同点なら小さいIDのキャラクターが残る
		int resultId = 0;
		int maxCount = 0;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				resultId = entry.getKey();
			}
		}

		return resultId;
	}

	// ===== 結果CRUD（Repositoryができてから作る） =====
}