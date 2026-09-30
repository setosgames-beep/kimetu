package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Questions;

@Mapper
public interface QuestionMapper {
	 List<Questions> findAllOrderByDisplayOrder();
	 
	    /** IDで設問を1件取得 */
	    Questions findById(Integer id);
}
