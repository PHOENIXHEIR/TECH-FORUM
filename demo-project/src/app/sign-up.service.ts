import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  signUpUrl = 'signup';

  constructor(private http: HttpClient) { }

  signUp(newUser){
    return this.http.post(this.signUpUrl, newUser);
  }
}
