package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
	/** 全設問を表示順で取得 */
    List<Question> findAllOrderByDisplayOrder();
 
    /** IDで設問を1件取得 */
    Question findById(Integer id);
 
    /** 設問を新規登録 */
    int insert(Question question);
 
    /** 設問を更新 */
    int update(Question question);
 
    /** IDで設問を削除 */
    int deleteById(Integer id);
}
