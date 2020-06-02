import { Component, OnInit, ViewChild, ElementRef, Output, EventEmitter } from '@angular/core';
import { Answer } from 'src/app/Models/inquiry';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  @ViewChild("odgovor1", null) odgovor1: ElementRef;
  @ViewChild("odgovor2", null) odgovor2: ElementRef;
  @ViewChild("odgovor3", null) odgovor3: ElementRef;
  @ViewChild("odgovor4", null) odgovor4: ElementRef;
  @Output() childComponent: EventEmitter<Array<Answer>> = new EventEmitter<Array<Answer>>();

  answers: Array<Answer> = new Array<Answer>();
  constructor() { 
    this.answers = new Array<Answer>();
    this.answers.push(new Answer());
    this.answers.push(new Answer());
    this.answers.push(new Answer());
    this.answers.push(new Answer());
  }

  ngOnInit() {
  }

  addAnswer(){
    this.answers[0].answer = this.odgovor1.nativeElement.value;
    this.answers[1].answer = this.odgovor2.nativeElement.value;
    this.answers[2].answer = this.odgovor3.nativeElement.value;
    this.answers[3].answer = this.odgovor4.nativeElement.value;
    this.childComponent.emit(this.answers);
  }
}
