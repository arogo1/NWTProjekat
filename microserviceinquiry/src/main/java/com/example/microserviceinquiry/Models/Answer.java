package com.example.microserviceinquiry.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column(name="answer_id")
    private int answerId;

    @NotEmpty
    @Size(min=3)
    @Column(name="answer")
    private String answer;

    @NotNull
    @Column(name="is_correct")
    private boolean isCorrect;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="question_id")
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

    @Override
	public String toString() {
		return answer + " " + answerId + " " + isCorrect;
	}
}