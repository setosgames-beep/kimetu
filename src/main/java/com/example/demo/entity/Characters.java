package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characters {
	private int id;
	
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	
	private String description;
	private String descriptionResult;
	
	private String characterImagePath;
	private String resultImagePath;
	
}