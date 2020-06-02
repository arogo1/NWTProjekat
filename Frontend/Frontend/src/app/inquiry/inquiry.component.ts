import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { QuestionGroup, Inquiry } from '../Models/inquiry';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-inquiry',
  templateUrl: './inquiry.component.html',
  styleUrls: ['./inquiry.component.css']
})
export class InquiryComponent implements OnInit {
  @ViewChild("inquiryName", null) inquiryName: ElementRef;

  private inquiry: Inquiry;
  private numberOfInquiry: Array<number> = [];
  inquiryForm: FormGroup;
  constructor() {
    this.inquiry = new Inquiry();
  }

  ngOnInit() {
    this.inquiryForm = new FormGroup({
      inquiryName: new FormControl()
    });
  }

  addQuestionGroup(){
    this.numberOfInquiry.push(1);
  }

  save(){
    this.inquiry.inquiryName = this.inquiryName.nativeElement.value
    //return this.http.get("localhost:8000/");
  }
}
