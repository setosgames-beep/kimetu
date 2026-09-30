package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChoiceCharacterScoreMapper {

	
	 
	    /** 複数の選択肢IDに紐づくスコアをまとめて取得（診断結果集計で使用） */
	    List<ChoiceCharacterScore> findByChoiceIds(@Param("choiceIds") List<Integer> choiceIds);
	 
	    /** スコアを新規登録 */
	    int insert(ChoiceCharacterScore score);
	 
	    /** スコアを更新 */
	    int update(ChoiceCharacterScore score);
	 
	    /** 選択肢IDとキャラクターIDを指定して削除 */
	    int delete(@Param("choiceId") Integer choiceId, @Param("characterId") Integer characterId);
}
