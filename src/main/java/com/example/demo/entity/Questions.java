package com.example.demo.entity;

import lombok.Data;

@Data
public class Questions {


    private Integer id;
    private String questionText;
    private Integer displayOrder;
 
    public Question() {
    }
 
    public Question(Integer id, String questionText, Integer displayOrder) {
        this.id = id;
        this.questionText = questionText;
        this.displayOrder = displayOrder;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getQuestionText() {
        return questionText;
    }
 
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
 
    public Integer getDisplayOrder() {
        return displayOrder;
    }
 
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
 
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", displayOrder=" + displayOrder +
                '}';
    }
}
