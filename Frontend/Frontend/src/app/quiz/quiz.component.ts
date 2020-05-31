import { Component, OnInit } from '@angular/core';
import { AppRoutingModule } from '../app-routing.module';
import { QuizService } from '../shared/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  constructor(private router: AppRoutingModule, private quizService: QuizService) { }

  ngOnInit() {
  }

}
