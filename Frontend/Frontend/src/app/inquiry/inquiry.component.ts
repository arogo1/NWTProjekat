import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { QuestionGroup, Inquiry } from '../Models/inquiry';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

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
  nesto: string;
  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.inquiry = new Inquiry();
  }

  ngOnInit() {
    this.inquiryForm = this.fb.group({
      inquiryName: ['', [Validators.required]]
    });
  }

  addQuestionGroup(){
    this.numberOfInquiry.push(1);
  }

  save(){
    //this.inquiry.inquiryName = this.inquiryName.nativeElement.value
    this.http.get<string>('http://localhost:8000/nesto').subscribe(response => {
      this.nesto = response;
    }), error =>{
      this.nesto = error;
    };
    }
  }
