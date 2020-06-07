import { Component, OnInit } from '@angular/core';
import { ApplUser } from '../Models/user.model';
import { NgForm } from '@angular/forms';
import { UserService } from '../shared/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: ApplUser

  //constructor(private userService: UserService) { }
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
      private userService: UserService,
      private http: HttpClient) {
    this.user = new ApplUser();
  }
  ngOnInit() {
    this.resetForm();
    // this.user.username="Test";
    // this.user.password="Test12345678";
    // this.user.role="USER";
    // this.user.loged=true;
  }
  resetForm(form? : NgForm) {
    if(form!=null)
    form.reset();
    // this.user = {
    //   username: '',
    //   password: ''
    // }
  }

  /*OnSubmit(form: NgForm) {
    this.userService.registerUser(form.value)
      .subscribe((data: any) => {
        if (data.Succeeded == true) 
          this.resetForm(form);
      });
  }*/
  onSubmit() {
    this.userService.registerUser(this.user).subscribe((data: any) => {
      if (data.Succeeded == true) 
        console.log("uspjesno nesto")
    });
  }
 
  gotoUserList() {
    this.router.navigate(['/user']);
  }

  registerUser(){
    this.http.post('http://localhost:8090/user-microservice/user', this.user, { headers: new HttpHeaders().set('Access-Control-Allow-Origin', '*')}).subscribe( response => {
      alert("User successfully registerd");
    })
  }
}
