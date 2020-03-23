package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    private int questionGroupId;
    private String question;

    public QuestionDTO(){}

    public QuestionDTO(int QuestionGroupId, String Question){
        questionGroupId = QuestionGroupId;
        question = Question;
    }

    public String GetQuesition(){
        return question;
    }
}