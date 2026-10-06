package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Diagnosis_results {
	
	private long id;
	
	private long userId;
	private int characterId;
	
	private LocalDateTime diagnosedAt;
	
}
