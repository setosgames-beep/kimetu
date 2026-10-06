package com.example.demo.entity;

import lombok.Data;

@Data
public class Choices {
	private int id;
	
	private int questionId;
	private int characterId;
	
	private String body;
	
}
