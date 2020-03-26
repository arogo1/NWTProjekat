package com.example.microserviceinquiry.ModelDTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="question_groupdto")
public class QuestionGroupDTO {
    
    @Id
    @GeneratedValue
    @Column(name="question_group_id")
    private int questionGroupId;

    // @Column(name="inquiry_id")
    // private int inquiryId;

    @NotEmpty
    @Size(min=3)
    @Column(name="question_group_name")
    private String questionGroupName;

    @NotNull
    @Column(name="number_of_question")
    private int numberOfQuestion;

    @NotNull
    @ManyToOne
    @JoinColumn(name="inquiry_id")
    private InquiryDTO inquiryDTO;

    @NotNull
    @OneToMany
    private List<QuestionDTO> questionDTO;
    
    public QuestionGroupDTO(){}

    public QuestionGroupDTO(int InquiryId, String QuestionGroupName, int NumberOfQuestion){
        // inquiryId = InquiryId;
        questionGroupName = QuestionGroupName;
        numberOfQuestion = NumberOfQuestion;
    }

    public void SetQuestions(List<QuestionDTO> questionDTOs){
        this.questionDTO = questionDTOs;
    }

    public List<QuestionDTO> GetQuestionDTOs(){
        return questionDTO;
    }

    public InquiryDTO GetInquiryDTO(){
        return inquiryDTO;
    }

    public void SetInquiryDTO(InquiryDTO inquiryDTO){
        this.inquiryDTO = inquiryDTO;
    }

    public String GetQuestionGroupName(){
        return questionGroupName;
    }

    public int GetNumberOfQuestion(){
        return numberOfQuestion;
    }

    // public void SetInquiryId(int InquiryId){
    //     this.inquiryId = InquiryId;
    // }

    public void SetQuestionGroupName(String QuestionGroupName){
        this.questionGroupName = QuestionGroupName;
    }

    public void SetNumberOfQuestion(int NumberOfQuestion){
        this.numberOfQuestion = NumberOfQuestion;
    }

    // public int GetInquiryId(){
    //     return inquiryId;
    // }
}