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
  private int doneQuizID;

  @Positive(message="Result must be nonnegative")
  @Column(name="userid")
    private int UserID;

    @Positive(message="Result must be nonnegative")
    @Column(name="quizid")
    private int QuizID;

    public DoneQuiz() {}
    
    public DoneQuiz(int userid, int quizid){
      QuizID = quizid;
      UserID = userid;
    }

    public int getdoneQuizID() {
      return doneQuizID;
    }

    public void setdoneQuizID(int id){
      this.doneQuizID = id;
    }

    public int getUserId() {
        return UserID;
      }

      public void setUserId(int id){
        this.UserID = id;
      }
    
      public int getQuizID() {
        return QuizID;
      }

      public void setQuizId(int id){
        this.QuizID = id;
      }
    
    
}