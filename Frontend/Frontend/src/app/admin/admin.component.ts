import { Component, OnInit } from '@angular/core';
import { ApplUser } from '../Models/user.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  users: ApplUser[] = [];
  user: ApplUser;
  constructor() {
    this.user = new ApplUser();
   }

  ngOnInit() {
    this.user.username="Test";
    this.user.role="USER"
    this.users.push(this.user);
  }

}
