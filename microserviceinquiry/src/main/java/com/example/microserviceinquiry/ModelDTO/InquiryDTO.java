package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name="inquirydto")
public class InquiryDTO{

    @Id
    @GeneratedValue
    @Column(name="inquiry_id")
    private int inquiryId;

    @NotNull
    @Column(name="user_id")
    private int userId;

    @NotNull
    @Column(name="category_id")
    private int categoryId;

    @NotEmpty
    @Size(min=3)
    @Column(name="inquiry_name")
    private String inquiryName;

    @NotNull
    @Column(name="number_of_question_group")
    private int numberOfQuestionGroup;

    @NotNull
    @OneToMany(mappedBy="inquiryDTO")
    private List<QuestionGroupDTO> questionGroups;

    public InquiryDTO(){}

    public InquiryDTO(int UserId, int CategoryId, String InquiryName, int NumberOfQuestionGroup){
        this.userId = UserId;
        this.categoryId = CategoryId;
        this.inquiryName = InquiryName;
        this.numberOfQuestionGroup = NumberOfQuestionGroup;
    }

    public List<QuestionGroupDTO> GetQuestionGroupDTO(){
        return questionGroups;
    }

    public void SetQuestionGroupsDTO(List<QuestionGroupDTO> questionGroupDTOs){
        this.questionGroups = questionGroupDTOs;
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