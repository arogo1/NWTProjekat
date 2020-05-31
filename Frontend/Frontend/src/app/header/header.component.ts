import { Component, OnInit } from '@angular/core';
import { QuizService } from '../shared/quiz.service';
import { AppRoutingModule } from '../app-routing.module';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private quizService : QuizService,private router : AppRoutingModule) { }

  ngOnInit() {
  }

  SignOut() {
    localStorage.clear();
    // clearInterval(this.quizService.timer);
    // this.router.navigate(['/login']);
  }

}
