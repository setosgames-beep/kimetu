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

//	Characters calculateResult(List<Integer> selectedChoiceIds);
	Characters calculateResult(Map<Integer, Integer> selects);
	
	// 有木：同点キャラクターを取得する処理。
	// TestControllerから呼び出され、15問の回答を集計した結果、
	// 最高得点が複数キャラクターになった場合に使用する。
	List<Characters> getTopCharacters(Map<Integer, Integer> selects);
}
