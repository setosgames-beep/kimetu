package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharacterMapper {
	/** 全キャラクターを取得 */
	List<Character> findAll();
	 
    /** IDでキャラクターを1件取得 */
    Character findById(Integer id);
 
    /** キャラクターを新規登録 */
    int insert(Character character);
 
    /** キャラクター情報を更新 */
    int update(Character character);
 
    /** IDでキャラクターを削除 */
    int deleteById(Integer id);
    
    
}
