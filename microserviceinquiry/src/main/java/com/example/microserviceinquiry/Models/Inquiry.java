package com.example.microserviceinquiry.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Inquiry")
public class Inquiry{

    @Id
    @GeneratedValue
    @Column(name="InquiryId")
    private int inquiryId;

    //@NotNull
    @Column(name="UserId")
    private int userId;

    //@NotNull
    @Column(name="CategoryId")
    private int categoryId;

    //@NotEmpty
    @Size(min=3)
    @Column(name="InquiryName")
    private String inquiryName;

    //@NotNull
    @Column(name="NumberOfQuestionGroup")
    private int numberOfQuestionGroup;

    //@NotNull
    @OneToMany(mappedBy="inquiry")
    private List<QuestionGroup> questionGroups;

    public Inquiry(){}

    public Inquiry(int UserId, int CategoryId, String InquiryName, int NumberOfQuestionGroup){
        this.userId = UserId;
        this.categoryId = CategoryId;
        this.inquiryName = InquiryName;
        this.numberOfQuestionGroup = NumberOfQuestionGroup;
    }

    public List<QuestionGroup> GetQuestionGroup(){
        return questionGroups;
    }

    public void SetQuestionGroups(List<QuestionGroup> questionGroups){
        this.questionGroups = questionGroups;
    }

    public int GetInquiryId(){
        return inquiryId;
    }

    public void SetInquiryId(int InquiryId){
        this.inquiryId = InquiryId;
    }

    public String GetInquiryName(){
        return inquiryName;
    }

    public int GetNumberOfQuestion(){
        return numberOfQuestionGroup;
    }

    public void setUserId(int UserId){
        this.userId = UserId;
    }

    public void setCategoryId(int CategoryId){
        this.categoryId = CategoryId;
    }

    public void setInquiryName(String InquiryName){
        this.inquiryName = InquiryName;
    }

    public void setNumberOfQuestionGroup(int NumberOfQuestionGroup){
        this.numberOfQuestionGroup = NumberOfQuestionGroup;
    }
}