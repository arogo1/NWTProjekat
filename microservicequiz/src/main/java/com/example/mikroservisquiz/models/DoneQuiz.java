package com.example.mikroservisquiz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Entity
public class DoneQuiz{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="userid")
    private Integer UserID;

    //@Positive(message="Result must be nonnegative")
    @Column(name="quizid")
    private Integer DoneQuizID;

    protected DoneQuiz() {}
    
    public DoneQuiz(Integer id){
      UserID = id;
    }
    public int getUserId() {
        return UserID;
      }

      public void setUserId(Integer id){
        this.UserID = id;
      }
    
      public int getDoneQuizID() {
        return DoneQuizID;
      }

      public void setDoneQuizId(Integer id){
        this.DoneQuizID = id;
      }
    
    
}