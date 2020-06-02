import { Component, OnInit } from '@angular/core';
import { QuizService } from '../shared/quiz.service';
import { AppRoutingModule } from '../app-routing.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private quizService : QuizService,private router : Router) { }

  ngOnInit() {
  }

  SignOut() {
    localStorage.clear();
    this.router.navigate(['/login']);
    // clearInterval(this.quizService.timer);
    // this.router.navigate(['/login']);
  }

}
