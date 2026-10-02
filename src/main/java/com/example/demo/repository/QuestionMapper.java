package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Questions;

@Mapper
public interface QuestionMapper {
	/** 全設問を表示順で取得 */
    List<Questions> findAllOrderByDisplayOrder();
 
//    /** IDで設問を1件取得 */
//    Questions findById(Integer id);
// 
//    /** 設問を新規登録 */
//    int insert(Questions question);
// 
//    /** 設問を更新 */
//    int update(Questions question);
// 
//    /** IDで設問を削除 */
//    int deleteById(Integer id);
}
