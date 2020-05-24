import { Component, OnInit } from '@angular/core';
import { QuestionGroup, Inquiry } from '../Models/inquiry';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inquiry',
  templateUrl: './inquiry.component.html',
  styleUrls: ['./inquiry.component.css']
})
export class InquiryComponent implements OnInit {

  public inquiry: Inquiry;
  y = ["j", "d", "t"];
  constructor(
    //private http: HttpClient
    ) {
    this.inquiry = new Inquiry();
  }

  ngOnInit() {
  }

  addQuestionGroup(){
    this.inquiry.questionGroups.push(new QuestionGroup());
  }

  save(){
    //return this.http.post("localhost:8000/saveInquiry", this.inquiry);
  }
}
