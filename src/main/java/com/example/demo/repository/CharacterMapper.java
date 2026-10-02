package com.example.demo.repository;

import java.util.List; // ★追加

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Characters; // ★追加

@Mapper
public interface CharacterMapper {
	/** 全キャラクターを取得（一覧表示用） */
	List<Characters> findAll(); // ★コメントアウトを解除、Character → Characters

	/** IDでキャラクターを1件取得（診断結果画面に「炭治郎などの詳細を貼る用」） */
	Characters findById(int id); // ★Character → Characters

	//    /** キャラクターを新規追加（開発時のマスタ登録用） */
	//    int insert(Character character);
	//
	//    /** キャラクター情報の更新 */
	//    int update(Character character);
	//
	//    /** IDでキャラクターを削除 */
	//    int deleteById(int id);
	//
}