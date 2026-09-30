package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Characters;

public interface CharacterService {
	List<Characters> getAllCharacters();
	Characters getCharacterById(int id);
	void saveCharacter(Characters character);
}