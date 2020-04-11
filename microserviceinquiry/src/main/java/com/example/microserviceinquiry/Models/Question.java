package com.example.microserviceinquiry.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Question")
public class Question {

    @Id
    @GeneratedValue
    @Column(name="QuestionId")
    private int questionId;

    @NotEmpty
    @Size(min=3)
    @Column(name="Question")
    private String question;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="QuestionGroupId")
    private QuestionGroup questionGroup;

    @NotNull
    @OneToMany(mappedBy="question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<Answer>();

    public Question(){}

    public Question(String Question){
        question = Question;
    }

    public void SetAnswers(List<Answer> answerDTOs){
        this.answers = answerDTOs;
    }

    public List<Answer> GetAnswerDTO(){
        return answers;
    }

    public String GetQuesition(){
        return question;
    }

    public void SetQuestionGroupId(QuestionGroup questionGroup){
        this.questionGroup = questionGroup;
    }

    public void SetQuestion(String question){
        this.question = question;
    }

    public QuestionGroup GetQuestionGroup(){
        return questionGroup;
    }

    @Override
	public String toString() {
		return question + " " + questionId;
	}
}