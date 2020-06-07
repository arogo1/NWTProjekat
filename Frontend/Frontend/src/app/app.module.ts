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
import { RegisterComponent } from './register/register.component';
import { UserService } from './shared/user.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule, FormBuilder } from '@angular/forms';
import { AdminComponent } from './admin/admin.component';


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
    StartQuizComponent,
    RegisterComponent,
    AdminComponent
  ],
   imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [QuizService, AuthGuard,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
