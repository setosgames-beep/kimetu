package com.example.demo.entity;

import lombok.Data;

@Data
public class Characters {
	// キャラクターID
	private int id;
	// キャラクターの名前（例：竈門炭治郎）
	private String name;
	// キャラクターの基本説明文
	private String description;
	
	// 【新しく追加】診断結果の画面に出す、より詳しい説明文
	private String description_results;
	
 // 【名前変更】キャラクター一覧画面で使う画像の保存場所（パス）
	private String character_image_path;
    
 // 【新しく追加】診断結果画面で使う専用画像の保存場所（パス）
	private String result_image_path;
}