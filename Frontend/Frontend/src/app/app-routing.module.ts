import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { InquiryComponent } from './inquiry/inquiry.component';
import { QuizComponent } from './quiz/quiz.component';


const routes: Routes = [
  { path: 'home-component', component: HomeComponent },
  { path: '', component: LoginComponent},
  { path: 'create-inquiry', component: InquiryComponent},
  { path: 'quiz', component: QuizComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
