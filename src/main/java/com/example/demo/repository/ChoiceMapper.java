package com.example.demo.repository;

import java.awt.Choice;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChoiceMapper {
	List<Choice> findByQuestionId(Integer questionId);
	 
    /** IDで選択肢を1件取得 */
    Choice findById(Integer id);
 
    /** 選択肢を新規登録 */
    int insert(Choice choice);
 
    /** 選択肢を更新 */
    int update(Choice choice);
 
    /** IDで選択肢を削除 */
    int deleteById(Integer id);
}
