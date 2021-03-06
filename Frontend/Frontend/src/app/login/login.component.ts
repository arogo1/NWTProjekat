import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApplUser } from '../Models/user.model';
import { UserService } from '../shared/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: ApplUser

  constructor(private userService: UserService, private router : Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.userService.userAuthentication();
  }
}
