import { Component, OnInit } from '@angular/core';
import { Post } from '../../post';
import { PostService } from '../post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  post: Post = {heading: '', body: ''};
  errorUnknown: boolean = false;
  errorEmptyField: boolean = false;

  constructor(private postService: PostService, private router: Router) { }

  ngOnInit() {
  }

  submitPost(){
    if (this.post.heading==='' || this.post.body===''){
      this.errorEmptyField = true;
      return;
    }
    this.errorEmptyField = false;
    
    this.postService.addPost(this.post).subscribe(
      (response: Post) => {
        this.router.navigateByUrl('home');
      },
      (error) => {
        console.log(error);
        this.errorUnknown = true;
      }
    );
  }
}
