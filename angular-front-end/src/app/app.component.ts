import { Component, TemplateRef } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { BsModalService, BsModalRef } from 'ngx-bootstrap';
import { User } from '../user';
import { SignUpService } from './sign-up.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'discuss';
  loggedOutFlag = false;
  logOutError = false;
  modalRef: BsModalRef;
  newUser: User = {emailId: '', password: '', repeatPassword: ''};
  errorNoMatch: boolean = false;
  errorOnServer: boolean = false;
  errorEmpty: boolean = false;

  constructor(private singupService: SignUpService, private modalService: BsModalService, private loginService: LoginService, private router: Router){
    // this.loginService.authenticate(undefined, undefined, undefined);
  }
  
  authenticated(){
    return LoginService.authenticated;
  }

  logout(){
    this.loginService.logout(()=>{
      //success
      this.router.navigateByUrl('');
      this.loggedOutFlag = true;
    },
    () => {
      //error
      this.logOutError = true;
    });
  }

  signUp(){
    var ok = this.validateInputs();
    console.log(ok);
    if (ok){
      this.singupService.signUp(this.newUser).subscribe(
        (response: Response) => {
          if (response.hasOwnProperty('error')){
            this.errorOnServer = response['error'];
          }else{
            this.router.navigateByUrl('login');
            this.modalRef.hide();
          }
        },
        (error) =>{
          console.log(error);
        }
      )
    }
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  validateInputs(): boolean{

    this.errorEmpty = false;
    this.errorNoMatch = false;
    if (this.newUser.password !== this.newUser.repeatPassword){
      this.errorNoMatch = true;
      return false;
    }
    if (this.newUser.emailId === '' || this.newUser.password === '' || this.newUser.repeatPassword === ''){
      this.errorEmpty = true;
      return false;
    }
    
    return true;
  }

  getLoggedInUser():string{
    return LoginService.loggedInUser;
  }
}
