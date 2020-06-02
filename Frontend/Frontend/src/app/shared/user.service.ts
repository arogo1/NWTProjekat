import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import {  Response } from "@angular/http";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../Models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersUrl: string;
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/user';
   }

  public registerUser(user : User){
    const body: User = {
      UserName: user.UserName,
      Password: user.Password
    }
    return this.http.post<User>(this.usersUrl,user);
  }
}
