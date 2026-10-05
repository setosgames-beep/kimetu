package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Diagnosis_results {

    private long id;

    private long user_id;

    private int character_id;

    private LocalDateTime diagnosed_at;

	
}
