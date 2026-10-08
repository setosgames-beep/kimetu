package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choices {
	private int id;
	
	private Integer questionId;
	private Integer characterId;
	
	private String body;
	
}
