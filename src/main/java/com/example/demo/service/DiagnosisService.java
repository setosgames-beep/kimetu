package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Diagnosis_results;

public interface DiagnosisService {

	// 診断ロジック：回答（選択肢ID）のリストから、結果のキャラクターIDを返す
	int diagnose(List<Integer> choiceIds);

	// 診断結果を登録する
	void insert(Diagnosis_results result);

	// ユーザーの診断履歴を新しい順で取得する
	List<Diagnosis_results> findByUserId(int userId);
}