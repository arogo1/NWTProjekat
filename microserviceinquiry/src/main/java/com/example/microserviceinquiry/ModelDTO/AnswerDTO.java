package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="answerdto")
public class AnswerDTO {

    @Id
    @GeneratedValue
    @Column(name="answer_id")
    private int answerId;

    // @Column(name="question_id")
    // private int questionId;

    @NotEmpty
    @Size(min=3)
    @Column(name="answer")
    private String answer;

    @NotNull
    @Column(name="is_correct")
    private boolean isCorrect;

    @NotNull
    @ManyToOne
    @JoinColumn(name="question_id")
    private QuestionDTO questionDTO;

    public AnswerDTO(){}

    public AnswerDTO(String Answer, boolean IsCorrect) {
        answer = Answer;
        isCorrect = IsCorrect;
    }

    public void SetQuestion(QuestionDTO questionDTO){
        this.questionDTO = questionDTO;
    }

    public QuestionDTO GetQuestionDTO(){
        return questionDTO;
    }

    public String GetAnswer(){
        return answer;
    }

    public boolean GetIsCorrect(){
        return isCorrect;
    }

    // public void SetQuestionId(int questionId){
    //     this.questionId = questionId;
    // }

    public void SetAnswer(String Answer){
        this.answer = Answer;
    }

    public void SetIsCorrect(Boolean isCorrect){
        this.isCorrect = isCorrect;
    }
}