package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionGroupDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionGroupId;
    private int inquiryId;
    private String questionGroupName;
    private int numberOfQuestion;
    
    public QuestionGroupDTO(){}

    public QuestionGroupDTO(int InquiryId, String QuestionGroupName, int NumberOfQuestion){
        inquiryId = InquiryId;
        questionGroupName = QuestionGroupName;
        numberOfQuestion = NumberOfQuestion;
    }

    public String GetQuestionGroupName(){
        return questionGroupName;
    }

    public int GetNumberOfQuestion(){
        return numberOfQuestion;
    }
}