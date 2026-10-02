package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Characters;
import com.example.demo.entity.Diagnosis_results;
import com.example.demo.service.CharacterService;
import com.example.demo.service.DiagnosisService;

import lombok.Data;

@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

	@Autowired
	private DiagnosisService diagnosisService;

	@Autowired
	private CharacterService characterService;

	// リクエスト用：{"userId": 1, "choiceIds": [1, 5, 9, 12]}（userIdは省略可）
	@Data
	public static class DiagnosisRequest {
		private Integer userId;
		private List<Integer> choiceIds;
	}

	// POST /api/diagnosis → 診断して結果のキャラクターを返す
	// userIdがあれば診断結果を保存する
	@PostMapping
	public Characters diagnose(@RequestBody DiagnosisRequest request) {
		int characterId = diagnosisService.diagnose(request.getChoiceIds());

		if (request.getUserId() != null) {
			Diagnosis_results result = new Diagnosis_results();
			result.setUser_id(request.getUserId());
			result.setCharacter_id(characterId);
			diagnosisService.insert(result);
		}

		return characterService.getCharacterById(characterId);
	}

	// GET /api/diagnosis/history/{userId} → ユーザーの診断履歴（新しい順）
	@GetMapping("/history/{userId}")
	public List<Diagnosis_results> getHistory(@PathVariable int userId) {
		return diagnosisService.findByUserId(userId);
	}
}