import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { QuestionGroup, Question } from 'src/app/Models/inquiry';

@Component({
  selector: 'app-question-group',
  templateUrl: './question-group.component.html',
  styleUrls: ['./question-group.component.css']
})
export class QuestionGroupComponent implements OnInit {
  @Output() childComponent: EventEmitter<QuestionGroup> = new EventEmitter<QuestionGroup>();


  private questionGroup: QuestionGroup;
  private createQuestion: Array<number> = [];
  constructor() { 
    this.questionGroup = new QuestionGroup();
  }

  ngOnInit() {
  }

  addQuestion(){
    this.createQuestion.push(1);
  }

  onKey(event){
    this.questionGroup.questionGroupName = event.target.value;
  }

  fetchChild(data){
    this.questionGroup.questions = data;
  }
}
