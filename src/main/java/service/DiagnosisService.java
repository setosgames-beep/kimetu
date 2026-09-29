package service;

import java.util.List;

public interface DiagnosisService {

    // 診断ロジック：回答に紐づくキャラクターIDのリストから、結果のキャラクターIDを返す
    int diagnose(List<Integer> characterIds);

    // 結果CRUD（Repositoryができてから追加する）
    // Create：診断結果を登録する
    // Read  ：診断結果の一覧、1件の詳細を取得する
    // Update：診断結果を更新する
    // Delete：診断結果を削除する
}