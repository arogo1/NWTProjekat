package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnswerDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;
    private int questionId;
    private String answer;
    private boolean isCorrect;

    public AnswerDTO(){}

    public AnswerDTO(String Answer, boolean IsCorrect) {
        answer = Answer;
        isCorrect = IsCorrect;
    }

    public String GetAnswer(){
        return answer;
    }

    public boolean GetIsCorrect(){
        return isCorrect;
    }
}