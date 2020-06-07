import { Component, OnInit } from '@angular/core';
import { Inquiry, QuestionGroup, Question, Answer } from '../Models/inquiry';
import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { Quiz, DoneQuiz } from '../Models/Quiz';

@Component({
  selector: 'app-start-quiz',
  templateUrl: './start-quiz.component.html',
  styleUrls: ['./start-quiz.component.css']
})
export class StartQuizComponent implements OnInit {

  inquiry: Inquiry;
  questionGroup: QuestionGroup;
  question: Question;
  answers: Answer;
  quiz: Quiz;
  doneQuiz: DoneQuiz;
  constructor(private httpClient: HttpClient) {
    this.inquiry = new Inquiry();
    this.questionGroup = new QuestionGroup();
    this.answers = new Answer();
    this.question = new Question();
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
    this.question.question="Pitanje";
    this.answers.answerId=1;
    this.answers.isCorrect=true;
    this.answers.answer="Ovo je tacno";

    this.question.answers.push(this.answers);

    this.questionGroup.questions.push(this.question);
    this.inquiry.questionGroups.push(this.questionGroup);
  }

  done(){
    this.httpClient.post("http://localhost:8800/createQuiz", this.quiz).subscribe(response => {
      {
      }
    }), error => {
      alert("Ups, something went wrong");
    }
  }

  DoneQuiz(){
    this.httpClient.post("http://localhost:8800/createDoneQuiz", this.doneQuiz).subscribe(response => {
      {
      }
    }), error => {
      alert("Ups, something went wrong");
    }
  }
}
