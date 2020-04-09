package com.example.mikroservisquiz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Entity
public class DoneQuiz{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer UserID;

    @Positive(message="Result must be nonnegative")
    private Integer QuizID;

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
    
      public int getQuizID() {
        return QuizID;
      }

      public void setQuizId(Integer id){
        this.QuizID = id;
      }
    
    
}