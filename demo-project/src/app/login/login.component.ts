import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { User } from '../../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials:User = {emailId: '', password: ''};
  loginErrorFlag = false;
  constructor(private service: LoginService, private router: Router) { }

  ngOnInit() {
  }

  login(){
    this.service.authenticate(this.credentials, 
    () => {
      this.router.navigateByUrl('home');
    },
    () =>{
      this.loginErrorFlag = true;
    });
  }

  loginError(){
    return this.loginErrorFlag;
  }
}
