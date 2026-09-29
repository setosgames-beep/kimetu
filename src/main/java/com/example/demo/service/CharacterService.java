package com.example.demo.service;

import java.util.List;

import javax.xml.stream.events.Characters;

public interface CharacterService {
	
	// キャラクター登録
    void create(Characters character);

    // キャラクター全件取得
    List<Characters> findAll();

    // キャラクター1件取得
    Characters findById(int id);

    // キャラクター更新
    void update(Characters character);

    // キャラクター削除
    void delete(int id);

}
