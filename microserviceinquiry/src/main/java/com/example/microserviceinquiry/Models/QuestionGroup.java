package com.example.microserviceinquiry.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="QuestionGroup")
public class QuestionGroup {
    
    @Id
    @GeneratedValue
    @Column(name="QuestionGroupId")
    private int questionGroupId;

    //@NotEmpty
    @Size(min=3)
    @Column(name="QuestionGroupName")
    private String questionGroupName;

    //@NotNull
    @Column(name="NumberOfQuestion")
    private int numberOfQuestion;

    //@NotNull
    @ManyToOne
    @JoinColumn(name="InquiryId")
    private Inquiry inquiry;

    //@NotNull
    @OneToMany(mappedBy="question") 
    private List<Question> question;
    
    public QuestionGroup(){}

    public QuestionGroup(int InquiryId, String QuestionGroupName, int NumberOfQuestion){
        // inquiryId = InquiryId;
        questionGroupName = QuestionGroupName;
        numberOfQuestion = NumberOfQuestion;
    }

    public void SetQuestions(List<Question> questions){
        this.question = questions;
    }

    public List<Question> GetQuestions(){
        return question;
    }

    public Inquiry GetInquiry(){
        return inquiry;
    }

    public void SetInquiry(Inquiry inquiry){
        this.inquiry = inquiry;
    }

    public String GetQuestionGroupName(){
        return questionGroupName;
    }

    public int GetNumberOfQuestion(){
        return numberOfQuestion;
    }

    public void SetQuestionGroupName(String QuestionGroupName){
        this.questionGroupName = QuestionGroupName;
    }

    public void SetNumberOfQuestion(int NumberOfQuestion){
        this.numberOfQuestion = NumberOfQuestion;
    }
}