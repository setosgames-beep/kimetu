package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Choices;

@Mapper
public interface ChoiceMapper {
	 List<Choices> findByQuestionId(Integer questionId);
	 
	    /** IDで選択肢を1件取得 */
	    Choices findById(Integer id);
}
