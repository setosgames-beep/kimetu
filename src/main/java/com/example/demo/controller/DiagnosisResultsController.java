package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Diagnosis_results;
import com.example.demo.service.DiagnosisResultsService;

import lombok.RequiredArgsConstructor;

@RestController @RequestMapping("/api/diagnosis-results")
@RequiredArgsConstructor
public class DiagnosisResultsController {
	
    private final DiagnosisResultsService diagnosisResultsService;

    // GET /api/diagnosis-results/user/{userId} → ユーザーの診断履歴を取得
    @GetMapping("/user/{userId}")
    public List<Diagnosis_results> getDiagnosisResultsByUserId(@PathVariable long userId) {
        return diagnosisResultsService.getDiagnosisResultsByUserId(userId);
    }

    // POST /api/diagnosis-results → 診断結果を保存
    @PostMapping
    public void saveDiagnosisResult(@RequestBody Diagnosis_results diagnosisResult) {
        diagnosisResultsService.saveDiagnosisResult(diagnosisResult);
    }


}
