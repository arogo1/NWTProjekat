package com.example.microserviceinquiry.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Answer")
public class Answer {

    @Id
    @GeneratedValue
    @Column(name="AnswerId")
    private int answerId;

    //@NotEmpty
    @Size(min=3)
    @Column(name="Answer")
    private String answer;

    //@NotNull
    @Column(name="IsCorrect")
    private boolean isCorrect;

    //@NotNull
    @ManyToOne
    @JoinColumn(name="QuestionId")
    private Question question;

    public Answer(){}

    public Answer(String Answer, boolean IsCorrect) {
        answer = Answer;
        isCorrect = IsCorrect;
    }

    public void SetQuestion(Question questionDTO){
        this.question = questionDTO;
    }

    public Question GetQuestion(){
        return question;
    }

    public String GetAnswer(){
        return answer;
    }

    public boolean GetIsCorrect(){
        return isCorrect;
    }

    public void SetAnswer(String Answer){
        this.answer = Answer;
    }

    public void SetIsCorrect(Boolean isCorrect){
        this.isCorrect = isCorrect;
    }
}