package com.example.demo.repository;

//import java.awt.Choice; // ★誤り（Windowsの部品用クラス）のためコメントアウト
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Choices; // ★追加

@Mapper
public interface ChoiceMapper {
	//	 /** 全選択肢を取得 */
	//    List<Choice> findAll();

	/** 【超重要】特定の質問ID(questionId)に紐づく選択肢だけをまとめて取得 */
	List<Choices> findByQuestionId(int questionId); // ★Choice → Choices

	//    /** IDで選択肢を1件取得 */
	//    Choice findById(int id);
	// 
	//    /** 選択肢を新規登録 */
	//    int insert(Choice choice);
	// 
	//    /** 選択肢を更新 */
	//    int update(Choice choice);
	// 
	//    /** IDで選択肢を削除 */
	//    int deleteById(int id);	
}