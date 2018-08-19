import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { LoginService } from '../login.service';
import { PostService } from '../post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  allPosts;

  constructor(private router: Router, private loginService: LoginService, private postService: PostService) {
  }

  ngOnInit() {
    this.loginService.authenticate(undefined, undefined, undefined);
    this.loadPosts();
    // setInterval(()=>{this.loadPosts()}, 60000);
  }

  authenticated(){
    return LoginService.authenticated;
  }

  loadPosts(){
    this.postService.fetchPosts(
      (response: Response) => {
        this.allPosts = response;

        console.log(this.allPosts);
    });
  }

  addPost(){
    this.router.navigateByUrl('addpost');
  }
}