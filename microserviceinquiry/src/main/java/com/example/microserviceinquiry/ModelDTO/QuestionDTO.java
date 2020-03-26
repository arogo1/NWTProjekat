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
@Table(name="questiondto")
public class QuestionDTO {

    @Id
    @GeneratedValue
    @Column(name="question_id")
    private int questionId;

    // @Column(name="question_group_id")
    // private int questionGroupId;

    @NotEmpty
    @Size(min=3)
    @Column(name="question")
    private String question;

    @NotNull
    @ManyToOne
    @JoinColumn(name="question_group_id")
    private QuestionGroupDTO questionGroupDTO;

    @NotNull
    @OneToMany
    private List<AnswerDTO> answers;

    public QuestionDTO(){}

    public QuestionDTO(int QuestionGroupId, String Question){
        //questionGroupId = QuestionGroupId;
        question = Question;
    }

    public void SetAnswers(List<AnswerDTO> answerDTOs){
        this.answers = answerDTOs;
    }

    public List<AnswerDTO> GetAnswerDTO(){
        return answers;
    }

    public String GetQuesition(){
        return question;
    }

    public void SetQuestionGroupId(QuestionGroupDTO questionGroup){
        this.questionGroupDTO = questionGroup;
    }

    public void SetQuestion(String question){
        this.question = question;
    }

    public QuestionGroupDTO GetQuestionGroupDTO(){
        return questionGroupDTO;
    }
}