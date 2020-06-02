import { Component, OnInit } from '@angular/core';
import { User } from '../Models/user.model';
import { NgForm } from '@angular/forms';
import { UserService } from '../shared/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User

  //constructor(private userService: UserService) { }
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private userService: UserService) {
    this.user = new User();
  }
  ngOnInit() {
    this.resetForm();
  }
  resetForm(form? : NgForm) {
    if(form!=null)
    form.reset();
    this.user = {
      UserName: '',
      Password: ''
    }
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


}
