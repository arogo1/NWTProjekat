import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { QuestionGroup, Inquiry } from '../Models/inquiry';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Category } from '../Models/Category';

@Component({
  selector: 'app-inquiry',
  templateUrl: './inquiry.component.html',
  styleUrls: ['./inquiry.component.css']
})
export class InquiryComponent implements OnInit {
  @ViewChild("inquiryName", null) inquiryName: ElementRef;

  private inquiry: Inquiry;
  inquiryForm: FormGroup;
  categories: Category[] = [];
  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.inquiry = new Inquiry();
  }

  ngOnInit() {
    this.inquiryForm = this.fb.group({
      inquiryName: ['', [Validators.required]]
    });
    this.getCategories();
  }

  addQuestionGroup(){
    this.inquiry.questionGroups.push(new QuestionGroup());
  }

  save(){
    this.inquiry.inquiryName = this.inquiryName.nativeElement.value;
    this.http.post('http://localhost:8000/saveInquiry', this.inquiry).subscribe();
    }

    getCategories(){
       this.http.get<Category[]>('http://localhost:8000/getCategories', {headers: new HttpHeaders().set('Content-Type', 'application/json')})
       .subscribe(response => {
      this.categories = response;
    }), error =>{
      alert("Ops something went wrong");
    };
    }
  }
