package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InquiryDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inquiryId;
    private int userId;
    private int categoryId;
    private String inquiryName;
    private int numberOfQuestionGroup;

    public InquiryDTO(){}

    public InquiryDTO(int UserId, int CategoryId, String InquiryName, int NumberOfQuestionGroup){
        this.userId = UserId;
        this.categoryId = CategoryId;
        this.inquiryName = InquiryName;
        this.numberOfQuestionGroup = NumberOfQuestionGroup;
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