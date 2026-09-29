package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Diagnosis_results {
Long id;
String name;
int character_id;
LocalDateTime diagnosed_at;
}
