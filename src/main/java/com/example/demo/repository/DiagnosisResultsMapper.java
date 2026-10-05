package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Diagnosis_results;

@Mapper
public interface DiagnosisResultsMapper {

	/** 特定ユーザーの診断履歴を新しい順で取得 */
	List<Diagnosis_results> findByUserIdOrderByDiagnosedAtDesc(int userId);

	/** 診断結果を新規登録 */
	int insert(Diagnosis_results diagnosisResult);
}