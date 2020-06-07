import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { InquiryComponent } from './inquiry/inquiry.component';
import { QuizComponent } from './quiz/quiz.component';
import { ResultComponent } from './result/result.component';
import { from } from 'rxjs';
import { AuthGuard } from './auth/auth.guard';
import { StartQuizComponent } from './start-quiz/start-quiz.component';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
  { path: 'home-component', component: HomeComponent },
  { path: 'login', component: LoginComponent},
  { path: 'create-inquiry', component: InquiryComponent},
  { path: 'quiz', component: QuizComponent },
  { path: 'result', component: ResultComponent },
  {path:'',redirectTo:'/login',pathMatch:'full'},
  { path: 'start-quiz', component: StartQuizComponent},
  { path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
