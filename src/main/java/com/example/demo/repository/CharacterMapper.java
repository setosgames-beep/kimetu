package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Characters;

@Mapper
public interface CharacterMapper {
	/** 全キャラクターを取得 */
    List<Characters> findAll();
 
    /** IDでキャラクターを1件取得 */
    Characters findById(Integer id);
    
    
}
