import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-question-group',
  templateUrl: './question-group.component.html',
  styleUrls: ['./question-group.component.css']
})
export class QuestionGroupComponent implements OnInit {

  y = ["1", "2", "3"];
  constructor() { }

  ngOnInit() {
  }

}
