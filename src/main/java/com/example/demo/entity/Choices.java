package com.example.demo.entity;

import lombok.Data;

@Data
public class Choices {

	int id;
	int question_id;
	String body;
	
}
public Choice() {
}

public Choice(Integer id, Integer questionId, String choiceText) {
    this.id = id;
    this.questionId = questionId;
    this.choiceText = choiceText;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getQuestionId() {
    return questionId;
}

public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
}

public String getChoiceText() {
    return choiceText;
}

public void setChoiceText(String choiceText) {
    this.choiceText = choiceText;
}

@Override
public String toString() {
    return "Choice{" +
            "id=" + id +
            ", questionId=" + questionId +
            ", choiceText='" + choiceText + '\'' +
            '}';
}
