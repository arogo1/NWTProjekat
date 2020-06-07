import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { QuestionGroup, Question } from 'src/app/Models/inquiry';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-question-group',
  templateUrl: './question-group.component.html',
  styleUrls: ['./question-group.component.css']
})
export class QuestionGroupComponent implements OnInit {
  @Output() childComponent: EventEmitter<QuestionGroup> = new EventEmitter<QuestionGroup>();


  private questionGroup: QuestionGroup;
  questionGrupForm: FormGroup;
  constructor(private fb: FormBuilder) { 
    this.questionGroup = new QuestionGroup();
  }

  ngOnInit() {
  }

  addQuestion(){
    this.questionGroup.questions.push(new Question());
  }

  onKey(event){
    this.questionGroup.questionGroupName = event.target.value;
  }

  fetchChild(data){
    this.questionGroup.questions = data;
  }
}
