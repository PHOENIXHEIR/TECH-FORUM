import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../post';
import { LoginService } from './login.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  getPostUrl = 'user/getposts';
  addPostUrl = 'user/addpost';

  constructor(private http: HttpClient, private loginService: LoginService) { 
  }

  fetchPosts(successCallback, errorCallback?){
    this.http.get(this.getPostUrl, { withCredentials: true }).subscribe(
      (response: Response) => {
        successCallback(response);
      },
      (error) => {
        console.log(error);
        errorCallback? errorCallback(error) : {};
      }
    );
  }

  addPost(post: Post): Observable<Post>{
    return <Observable<Post>> this.http.post(this.addPostUrl, post, {withCredentials: true});
  }
}
