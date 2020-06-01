import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InquiryComponent } from './inquiry/inquiry.component';
import { QuizComponent } from './quiz/quiz.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { QuestionGroupComponent } from './inquiry/question-group/question-group.component';
import { QuestionComponent } from './inquiry/question-group/question/question.component';
import { ResultComponent } from './result/result.component';
import { QuizService } from './shared/quiz.service';
import { AuthGuard } from './auth/auth.guard';
import { StartQuizComponent } from './start-quiz/start-quiz.component';

// const appRoutes: Routes = [
//   { path: 'home-component', component: HomeComponent }
// ];

@NgModule({
  declarations: [
    AppComponent,
    InquiryComponent,
    QuizComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    QuestionGroupComponent,
    QuestionComponent,
    ResultComponent,
    StartQuizComponent
  ],
   imports: [
  //   RouterModule.forRoot(
  //     appRoutes,
  //     { enableTracing: true } // <-- debugging purposes only
  //   ),
    BrowserModule,
    AppRoutingModule
  ],
  providers: [QuizService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
