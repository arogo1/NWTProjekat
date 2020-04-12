package com.example.microserviceinquiry.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

    @NotNull
    @Column(name="UserId")
    private int userId;

    @NotNull
    @Column(name="CategoryId")
    private int categoryId;

    @NotEmpty
    @Size(min=3)
    @Column(name="inquiry_name")
    private String inquiryName;

    @NotNull
    @Column(name="NumberOfQuestionGroup")
    private int numberOfQuestionGroup;

    @NotNull
    @OneToMany(mappedBy="inquiry", cascade = CascadeType.ALL)
    private List<QuestionGroup> questionGroups = new ArrayList<QuestionGroup>();

    public Inquiry(){}

    public Inquiry(int UserId, int CategoryId, String InquiryName, int NumberOfQuestionGroup, 
        List<QuestionGroup> questionGroups){
        this.userId = UserId;
        this.categoryId = CategoryId;
        this.inquiryName = InquiryName;
        this.numberOfQuestionGroup = NumberOfQuestionGroup;
        this.questionGroups = questionGroups;
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

    public int GetCategoryId(){
        return categoryId;
    }

    public int GetUserId(){
        return userId;
    }

    public void SetUserId(int UserId){
        this.userId = UserId;
    }

    public void SetCategoryId(int CategoryId){
        this.categoryId = CategoryId;
    }

    public void SetInquiryName(String InquiryName){
        this.inquiryName = InquiryName;
    }

    public void SetNumberOfQuestionGroup(int NumberOfQuestionGroup){
        this.numberOfQuestionGroup = NumberOfQuestionGroup;
    }

    @Override
	public String toString() {
		return inquiryName + " " + numberOfQuestionGroup + " " + categoryId + " " + inquiryId + " " + userId;
	}
}