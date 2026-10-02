package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Characters;
import com.example.demo.repository.CharacterMapper;
import com.example.demo.service.CharacterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
	
	private final CharacterMapper characterMapper;
	
	@Override
	public List<Characters> getAllCharacters() {
		return characterMapper.findAll();
	}
	
	@Override
	public Characters getCharacterById(int id) {
		return characterMapper.findById(id);
	}
	
//	@Override
//	public void saveCharacter(Characters character) {
//		characterMapper.save(character);
//	}
}
