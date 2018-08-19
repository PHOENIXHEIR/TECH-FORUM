import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  authUrl = 'user';
  logoutUrl = 'logout';
  static authenticated = false;
  static loggedInUser: string = '';
  headers: HttpHeaders;

  constructor(private http: HttpClient) { console.log('AUTH: '+LoginService.authenticated); }

  authenticate(credentials, successCallback, errorCallback){

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.emailId + ':' + credentials.password)
    } : {} );

    this.http.get(this.authUrl, { headers: headers, withCredentials:true }).subscribe( (resposnse) => {
        if (resposnse.hasOwnProperty('name')){
          LoginService.authenticated = true;
          LoginService.loggedInUser = resposnse['name'];

          console.log('AUTH-RESP-OK: '+LoginService.authenticated);
        }else{
          LoginService.loggedInUser = '';
          LoginService.authenticated = false;

          console.log('AUTH-RESP-ELSE: '+LoginService.authenticated);
        }
        return successCallback && successCallback();
      },
      (error) => {
        return errorCallback && errorCallback();
      }
    );
  }

  logout(successCallback, errorCallback){
    this.http.post(this.logoutUrl, {}, { withCredentials:true }).subscribe(
      (succsess) => {
        LoginService.loggedInUser = '';
        LoginService.authenticated = false;
        return successCallback && successCallback();
      },
      (error) => {
        console.log(error);
        return errorCallback && errorCallback();
      });
  }
}
