package com.example.demo.service; 
import java.util.List;

import com.example.demo.entity.Diagnosis_results;

public interface DiagnosisService {

    // 診断ロジック：回答に紐づくキャラクターIDのリストから、結果のキャラクターIDを返す
    int diagnose(List<Integer> characterIds);

    // 結果CRUD
    // Create：診断結果を登録する
    void insert(Diagnosis_results result);

    // Read  ：診断結果の一覧、1件の詳細を取得する
    List<Diagnosis_results> findAll();
    Diagnosis_results findById(Long id);

    // Update：診断結果を更新する
    void update(Diagnosis_results result);

    // Delete：診断結果を削除する
    void delete(Long id);
}