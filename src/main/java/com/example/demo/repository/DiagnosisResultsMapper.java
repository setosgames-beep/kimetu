package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Diagnosis_results;

@Mapper
public interface DiagnosisResultsMapper {
	List<Diagnosis_results> findAll();
	 
    /** IDで診断結果を1件取得 */
    Diagnosis_results findById(Long id);
}
