package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Characters;

@Mapper
public interface CharacterMapper {
	  /** 全キャラクターを取得（一覧表示用） */
    List<Characters> findAll();
 
    /** IDでキャラクターを1件取得（診断結果画面に「炭治郎」などの詳細を貼る用） */
    Characters findById(int id);
 
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
