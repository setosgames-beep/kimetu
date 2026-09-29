package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Choice_character_scores;

@Mapper
public interface ChoiceCharacterScoreMapper {

    /** 指定した選択肢に紐づくスコアを全件取得（診断ロジックで使用） */
    List<Choice_character_scores> findByChoiceId(Integer choiceId);
 
    /** 複数の選択肢IDに紐づくスコアをまとめて取得（診断結果集計で使用） */
    List<Choice_character_scores> findByChoiceIds(@Param("choiceIds") List<Integer> choiceIds);
}
