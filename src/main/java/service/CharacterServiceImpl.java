package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Characters;
import com.example.demo.repository.CharacterMapper;

@Service
public class CharacterServiceImpl implements CharacterService {
	
	@Autowired
	private CharacterMapper characterMapper;
	
	@Override
	public List<Characters> getAllCharacters() {
		return characterMapper.findAll();
	}
	
	@Override
	public Characters getCharacterById(int id) {
		return characterMapper.findById(id);
	}
	
	@Override
	public void saveCharacter(Characters character) {
		characterMapper.save(character);
	}
}