import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import {  Response } from "@angular/http";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ApplUser } from '../Models/user.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersUrl: string;
  constructor(private http: HttpClient, private router : Router) {
    this.usersUrl = 'http://localhost:8080/user';
   }

  public registerUser(user : ApplUser){
    const body: ApplUser = {
      username: user.username,
      password: user.password,
      role: user.role,
      loged: user.loged,
      userId: 1
    }
    return this.http.post<ApplUser>(this.usersUrl,user);
  }

  userAuthentication() {
    this.router.navigate(['/home-component']);
    //uraditi
  }
}
