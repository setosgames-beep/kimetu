package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Characters;
import com.example.demo.entity.Choices;
import com.example.demo.form.DiagnosisForm;
import com.example.demo.service.TestService;
import com.example.demo.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final UsersService usersService;
	private final TestService testService;

	/*------------------ プレーンhtmlでのテスト用 -------------------*/
	@GetMapping("/test")
	public String testView() {
		return "diagnosis/tester/index";
	}
	
	@GetMapping("/test/characters")
	public String testCharacter(Model model) {
		model.addAttribute("characterList", testService.getAllCharacters());
		return "diagnosis/tester/characters";
	}
	
	@GetMapping("/test/question")
	public String testQuestionsView(@ModelAttribute DiagnosisForm form, Model model) {
		model.addAttribute("map", testService.getQuestionsAndChoices());
		return "diagnosis/tester/question";
	}
	
	@PostMapping("/test/diagnosis/submit")
	public String testSubmit(@ModelAttribute DiagnosisForm form, Model model) {
		
		// 1.htmlでrequiredの最終確認(全部選択したかどうかの確認）
		int totalQuestions = testService.getQuestionsAndChoices().size();
		int answeredQuestions = form.getSelects().size();
		
		if (answeredQuestions < totalQuestions) {
			// 1.質問と選択肢のマップを再セット
			model.addAttribute("map", testService.getQuestionsAndChoices());
			// 2.ユーザーが選択したデータが入っているformを返す
			model.addAttribute("diagnosisForm", form);
			model.addAttribute("error", "すべての質問に回答してください。");
			return "diagnosis/tester/question";
		}
		
		// 有木：15問の回答をTestServiceに渡して、最高得点のキャラクターを取得する。
		// 有木：1人なら通常の結果画面、複数人なら最後の質問へ進ませる。
		List<Characters> topCharacters = testService.getTopCharacters(form.getSelects());

		// 有木：最高得点のキャラクターが1人だけなら、今まで通り結果画面を表示する。
		if (topCharacters.size() == 1) {

			model.addAttribute("character", topCharacters.get(0));

			return "diagnosis/result";
		}

		// 有木：最高得点が2人以上なら、まだ結果を確定せず最後の質問へ進む。

		// 有木：同点になったキャラクターだけを最後の質問画面に渡す。
		model.addAttribute("topCharacters", topCharacters);

		// 有木：DBから16問目の「最後の質問」を取得して画面に渡す。
		model.addAttribute("question", testService.getQuestionById(16));

		// 有木：同点になったキャラクターのIDだけを取り出す。
		// 有木：このIDを使って16問目の選択肢をDBから絞り込む。
		List<Integer> topCharacterIds = topCharacters.stream()
		        .map(Characters::getId)
		        .toList();

		// 有木：最終質問に渡すキャラクターIDを確認する。
		// 有木：今回のテストでは炭治郎(1)と伊之助(3)が入る想定。

		model.addAttribute("choices",
		        testService.getFinalChoices(topCharacterIds));
		// 有木：最終質問の画面を表示する。
		return "diagnosis/tester/finalQuestion";
	}
	
	/*------------------  -------------------*/
	@GetMapping("/")
	public String diagnosisView(Model model) {
		return "diagnosis/index";
	}
	
	@GetMapping("/characters")
	public String charactersView(Model model) {
		model.addAttribute("characterList", testService.getAllCharacters());
		return "diagnosis/characters";
	}
	
	@GetMapping("/questions")
	public String questionsView(@ModelAttribute DiagnosisForm form, Model model) {
		model.addAttribute("map", testService.getQuestionsAndChoices());
//		model.addAttribute("diagnosisForm", new DiagnosisForm());
		return "diagnosis/questions";
	}
	
	@PostMapping("/diagnosis/submit")
	public String submit(@ModelAttribute DiagnosisForm form, Model model) {
		
		// 1.htmlでrequiredの最終確認(全部選択したかどうかの確認）
		int totalQuestions = testService.getQuestionsAndChoices().size();
		int answeredQuestions = form.getSelects().size();
		
		if (answeredQuestions < totalQuestions) {
			// 1.質問と選択肢のマップを再セット
			model.addAttribute("map", testService.getQuestionsAndChoices());
			// 2.ユーザーが選択したデータが入っているformを返す
			model.addAttribute("diagnosisForm", form);
			model.addAttribute("error", "すべての質問に回答してください。");
			return "diagnosis/questions";
		}
		
		// 2.フォームの値を受け取て集計にまわす
		Characters resultCharacter = testService.calculateResult(form.getSelects());
		
		// 3.集計結果を受け取り、結果画面にまわす
		model.addAttribute("character", resultCharacter);
		return "diagnosis/result";
	}
	
	// 有木：16問目で選択された選択肢を受け取る。
	// 有木：finalQuestion.htmlから「結果を見る」ボタンで呼ばれる。
	@PostMapping("/test/diagnosis/final")
	public String finalSubmit(@RequestParam int choiceId, Model model) {

	    // 有木：選択された選択肢をDBから取得する。
	    // 有木：この選択肢に紐づいているcharacterIdを確認するために使用する。
	    Choices choice = testService.getChoiceById(choiceId);

	    // 有木：選択肢に紐づいているキャラクターIDから、
	    // 有木：最終的な診断結果のキャラクター情報を取得する。
	    Characters resultCharacter =
	            testService.getCharacterById(choice.getCharacterId());

	    // 有木：結果画面にキャラクター情報を渡す。
	    model.addAttribute("character", resultCharacter);

	    // 有木：既存の診断結果画面を表示する。
	    return "diagnosis/result";
	}
	
	@GetMapping("/username")
	public String usernameView() {
	    return "diagnosis/username";
	}
	
//	@PostMapping("/questions")
//	public String questionsWithUsername(@RequestParam("name") String name) {
//	    System.out.println("入力されたユーザー名：" + name);
//	    Users user = new Users();
//	    user.setName(name);
//	    usersService.saveUser(user);
//	    return "diagnosis/tester/questions";
//	}
	
}
