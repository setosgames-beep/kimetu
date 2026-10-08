package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Choices;

@Mapper
public interface ChoiceMapper {
//	 /** 全選択肢を取得 */
//    List<Choices> findAll();

    /** 【超重要】特定の質問ID(questionId)に紐づく選択肢だけをまとめて取得 */
    List<Choices> findByQuestionId(int questionId);

 // 有木：最後の質問で、同点になったキャラクターに対応する選択肢だけ取得する。
 // 有木：characterIdを使って「このキャラクターの選択肢」をDBから探す。
 List<Choices> findByCharacterId(int characterId);
 
//    /** IDで選択肢を1件取得 */
     Choices findById(int id);
//
//    /** 選択肢を新規登録 */
//    int insert(Choices choice);
//
//    /** 選択肢を更新 */
//    int update(Choices choice);
//
//    /** IDで選択肢を削除 */
//    int deleteById(int id);
}