package com.practice.springbootdemo.controllers;

import com.practice.springbootdemo.models.Post;
import com.practice.springbootdemo.repositories.RoleRepository;
import com.practice.springbootdemo.services.PostService;
import com.practice.springbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    //end point to check whether any user is logged in.
    @GetMapping
    public Principal user(Principal user){
        return user;
    }

    @GetMapping("/getposts")
    public List getPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @DeleteMapping("/deletepost/{id}")
    public void deletePost(@PathVariable String id){
        postService.deletePost(id);
    }
}
