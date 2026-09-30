package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Characters;

import service.CharacterService;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	// GET /api/characters → 全件取得
	@GetMapping
	public List<Characters> getAllCharacters() {
		return characterService.getAllCharacters();
	}
	
	// GET /api/characters/{id} → 1件取得
	@GetMapping("/{id}")
	public Characters getCharacterById(@PathVariable int id) {
		return characterService.getCharacterById(id);
	}
	
	// POST /api/characters → 新規登録
	@PostMapping
	public void createCharacter(@RequestBody Characters character) {
		characterService.saveCharacter(character);
	}
}