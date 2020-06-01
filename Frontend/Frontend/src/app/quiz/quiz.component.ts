import { Component, OnInit } from '@angular/core';
import { AppRoutingModule } from '../app-routing.module';
import { QuizService } from '../shared/quiz.service';
import { Inquiry, QuestionGroup, Question, Answer } from '../Models/inquiry';
import { Route } from '@angular/compiler/src/core';
import { Routes } from '@angular/router';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  inquirys: Array<Inquiry>;
  inquiry: Inquiry;
  questionGroup: QuestionGroup;
  question: Question;
  answers: Answer;
  constructor(private quizService: QuizService) {
    this.inquiry = new Inquiry();
    this.questionGroup = new QuestionGroup();
    this.answers = new Answer();
    this.question = new Question();
    this.inquirys = new Array<Inquiry>();
   }

  ngOnInit() {
    this.inquiry.questionGroups = new Array<QuestionGroup>();
    this.questionGroup.questions = new Array<Question>();
    this.question.answers = new Array<Answer>();

    this.inquiry.inquiryName="Irma nema pojma";
    this.inquiry.categoryId = 1;
    this.inquiry.inquiryId = 1;
    this.questionGroup.numberOfQuestion = 1;
    this.questionGroup.questionGroupId = 2;
    this.questionGroup.questionGroupName = "Proba";

    this.question.questionId=1;
    this.answers.answerId=1;
    this.answers.isCorrect=true;
    this.answers.answer="Ovo je tacno";

    this.question.answers.push(this.answers);

    this.questionGroup.questions.push(this.question);
    this.inquiry.questionGroups.push(this.questionGroup);
    this.inquirys.push(this.inquiry);
  }

}
