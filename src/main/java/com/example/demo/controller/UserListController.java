package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Characters;
import com.example.demo.entity.Diagnosis_results;
import com.example.demo.entity.Users;
import com.example.demo.service.CharacterService;
import com.example.demo.service.DiagnosisResultsService;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserListController {

	private final UserService userService;                       // ③（仮）
	private final DiagnosisResultsService diagnosisResultsService;
	private final CharacterService characterService;

	// GET /users → ユーザー一覧
	@GetMapping("/users")
	public String list(Model model) {
		List<Users> users = userService.getAllUsers();           // ③（仮）

		// userId → 最新の診断結果のキャラクター名
		Map<Long, String> characterNames = new HashMap<>();
		for (Users u : users) {
			List<Diagnosis_results> results =
					diagnosisResultsService.getDiagnosisResultsByUserId(u.getId());
			if (!results.isEmpty()) {
				Characters c = characterService.getCharacterById(results.get(0).getCharacterId());
				characterNames.put(u.getId(), c.getFamilyName() + " " + c.getFirstName());
			}
		}

		model.addAttribute("users", users);
		model.addAttribute("characterNames", characterNames);
		return "diagnosis/users";
	}

	// POST /users/{id}/delete → 削除して一覧に戻る
	@PostMapping("/users/{id}/delete")
	public String delete(@PathVariable long id) {
		userService.deleteUser(id);                              // ③（仮）
		return "redirect:/users";
	}
}