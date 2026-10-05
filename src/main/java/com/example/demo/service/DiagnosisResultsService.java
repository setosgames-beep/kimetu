package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Diagnosis_results;

public interface DiagnosisResultsService {
	
	 List<Diagnosis_results> getAllDiagnosisResults();

	    Diagnosis_results getDiagnosisResultById(int id);

	    List<Diagnosis_results> getDiagnosisResultsByUserId(int userId);

	    void saveDiagnosisResult(Diagnosis_results diagnosisResult);

}
