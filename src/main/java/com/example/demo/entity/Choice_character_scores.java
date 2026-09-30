package com.example.demo.entity;

import lombok.Data;

@Data
public class Choice_character_scores {
int choice_id;
int character_id;
int score;


}
public ChoiceCharacterScore() {
}

public ChoiceCharacterScore(Integer choiceId, Integer characterId, Integer score) {
    this.choiceId = choiceId;
    this.characterId = characterId;
    this.score = score;
}

public Integer getChoiceId() {
    return choiceId;
}

public void setChoiceId(Integer choiceId) {
    this.choiceId = choiceId;
}

public Integer getCharacterId() {
    return characterId;
}

public void setCharacterId(Integer characterId) {
    this.characterId = characterId;
}

public Integer getScore() {
    return score;
}

public void setScore(Integer score) {
    this.score = score;
}

@Override
public String toString() {
    return "ChoiceCharacterScore{" +
            "choiceId=" + choiceId +
            ", characterId=" + characterId +
            ", score=" + score +
            '}';
}