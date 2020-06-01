import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  readonly rootUrl = 'http://localhost:4200';
  qns: any[];
  seconds: number;
  timer;
  qnProgress: number;
  correctAnswerCount: number = 0;

  constructor() { }
  displayTimeElapsed() {
    return Math.floor(this.seconds / 3600) + ':' + Math.floor(this.seconds / 60) + ':' + Math.floor(this.seconds % 60);
  }

  // private http: HttpClient
  
  // //provjeri na back ima li ovo
  // getQuestions() {
  //   return this.http.get(this.rootUrl + '/api/Questions');
  // }
  // //provjeri na backendu imas li 
  // getAnswers() {
  //   var body = this.qns.map(x => x.QnID);
  //   return this.http.post(this.rootUrl + '/api/Answers', body);
  // }

  // submitScore() {
  //   var body = JSON.parse(localStorage.getItem('participant'));
  //   body.Score = this.correctAnswerCount;
  //   body.TimeSpent = this.seconds;
  //   return this.http.post(this.rootUrl + "/api/UpdateOutput", body);
  // }
}
