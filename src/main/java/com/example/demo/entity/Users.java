package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Users {
	private long id;
	private String name;
	private String body;
	private LocalDateTime createdAt;
	
}
