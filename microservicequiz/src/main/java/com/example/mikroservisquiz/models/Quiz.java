package com.example.mikroservisquiz.models;

import javax.persistence.Column;
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
  @Column(name="quizid")
  private int QuizID;
  @Column(name="inquiryid")
  private int InquiryID;

  @PositiveOrZero(message="Result must be nonnegative")
  @Column(name="result")
  private int Result;

  @Column(name="number_of_answer")
  @PositiveOrZero(message="Number of answer must be nonnegative")
  private int NumberOfAnswer;

  public Quiz(int InquiryID, int Result, int NumberOfAnswer) {
    this.InquiryID = InquiryID;
    this.Result = Result;
    this.NumberOfAnswer = NumberOfAnswer;

  }
  protected Quiz() {
  }

  public int getId() {
    return QuizID;
  }

  public void SetQuizId(int Id) {
    this.QuizID = Id;
  }

  public int getInquiryID() {
    return InquiryID;
  }

  public void SetInquiryId(int inquiryId) {
    this.InquiryID = inquiryId;
  }

  public int getResul() {
    return Result;
  }

  public void SetResult(int result) {
    this.Result = result;
  }

  public int getNumberOfAnswers() {
    return NumberOfAnswer;
  }

  public void SetNumOfAns(int num) {
    this.NumberOfAnswer = num;
  }

  @Override
  public String toString() {
    return String.format("Quiz [id=%s,id=%s, result=%s, num=%s]", QuizID, InquiryID, Result, NumberOfAnswer);
  }
}
