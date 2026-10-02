package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Diagnosis_results;

@Mapper
public interface DiagnosisResultsMapper {
	  /** 全ユーザーの診断結果を取得 */
    List<Diagnosis_results> findAll();
 
    /** 【超重要】特定のユーザーID(userId)の過去の診断履歴を、新しい順でまとめて取得 */
    List<Diagnosis_results> findByUserIdOrderByDiagnosedAtDesc(int userId);
 
    /** 確定した診断結果をデータベースへ新規登録（履歴の保存） */
    int insert(Diagnosis_results diagnosisResult);
 
//    /** 診断履歴の削除（特定の履歴を消したい場合） */
//    int deleteById(int id);
}
