package com.example.mikroservisquiz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;

@Entity
// @Table(name ="quiz")

public class Quiz {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer QuizID;
  private Integer InquiryID;

  @PositiveOrZero(message="Result must be nonnegative")
  private Integer Result;

  @PositiveOrZero(message="Number of answer must be nonnegative")
  private Integer NumberOfAnswer;

  protected Quiz() {
  }

  public Quiz(Integer InquiryID, Integer Result, Integer NumberOfAnswer) {
    this.InquiryID = InquiryID;
    this.Result = Result;
    this.NumberOfAnswer = NumberOfAnswer;

  }

  public Integer getId() {
    return QuizID;
  }

  public void SetQuizId(Integer Id) {
    this.QuizID = Id;
  }

  public Integer getInquiryID() {
    return InquiryID;
  }

  public void SetInquiryId(Integer inquiryId) {
    this.InquiryID = inquiryId;
  }

  public Integer getResul() {
    return Result;
  }

  public void SetResult(Integer result) {
    this.Result = result;
  }

  public Integer getNumberOfAnswers() {
    return NumberOfAnswer;
  }

  public void SetNumOfAns(Integer num) {
    this.NumberOfAnswer = num;
  }

  @Override
  public String toString() {
    return String.format("Quiz [id=%s,id=%s, result=%s, num=%s]", QuizID, InquiryID, Result, NumberOfAnswer);
  }
}
