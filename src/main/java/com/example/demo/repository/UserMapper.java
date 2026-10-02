package com.example.demo.repository;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	 /** 全ユーザーを取得（管理画面用など） */
    List<User> findAll();
 
    /** IDでユーザーを1件取得（マイページ表示やログインチェック用） */
    User findById(int id);
 
    /** ユーザーを新規登録（ユーザーの作成） */
    int insert(User user);
 
    /** ユーザー情報の更新（名前の変更など） */
    int update(User user);
 
    /** IDでユーザーを削除（退会処理：紐づく診断結果も自動で消えます） */
    int deleteById(int id);
}
