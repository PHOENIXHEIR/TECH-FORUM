package com.practice.springbootdemo.services;

import com.practice.springbootdemo.models.Post;
import com.practice.springbootdemo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    @Autowired
    UserService userService;

    public List<Post> getAllPosts(){
        return repository.findAllByOrderByTimestampDesc();
    }

    public List<Post> getAllPostsByUser(String userEmailId){
        return repository.findByUserEmailId(userEmailId);
    }

    public Post addPost(Post post){
        post.setUserEmailId(userService.getLoggedInUserEmailId());
        post.setTimestamp(new Date(System.currentTimeMillis()));

        System.out.println("POST:" + post);

        return repository.save(post);
    }

    public void deletePost(String id){
        repository.deleteById(id);
    }
}
